package net.aicoder.speedcloud.icode.business.project.controller;

import com.alibaba.fastjson.JSONArray;
import com.yunkang.saas.bootstrap.monitor.annotation.BusinessFuncMonitor;
import com.yunkang.saas.common.framework.exception.ResourceNotFoundException;
import com.yunkang.saas.common.framework.spring.DateConverter;
import com.yunkang.saas.common.framework.web.ExcelUtil;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageRequest;
import com.yunkang.saas.common.framework.web.data.PageRequestConvert;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.aicoder.speedcloud.icode.business.project.domain.Component;
import net.aicoder.speedcloud.icode.business.project.domain.ComponentType;
import net.aicoder.speedcloud.icode.business.project.domain.Product;
import net.aicoder.speedcloud.icode.business.project.dto.ComponentAddDto;
import net.aicoder.speedcloud.icode.business.project.dto.ComponentCondition;
import net.aicoder.speedcloud.icode.business.project.dto.ComponentEditDto;
import net.aicoder.speedcloud.icode.business.project.service.ComponentService;
import net.aicoder.speedcloud.icode.business.project.service.ComponentTypeService;
import net.aicoder.speedcloud.icode.business.project.service.ProductService;
import net.aicoder.speedcloud.icode.business.project.valid.ComponentValidator;
import net.aicoder.speedcloud.icode.business.project.vo.ComponentTypeVO;
import net.aicoder.speedcloud.icode.business.project.vo.ComponentVO;
import net.aicoder.speedcloud.icode.business.project.vo.ProductVO;
import net.aicoder.speedcloud.icode.business.tplfile.domain.TplSet;
import net.aicoder.speedcloud.icode.business.tplfile.service.TplSetService;
import net.aicoder.speedcloud.icode.business.tplfile.vo.TplSetVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 管理组件
 * @author icode
 */
@Api(description = "组件", tags = "Component")
@RestController
@RequestMapping(value = "/icode/project/component")
public class ComponentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComponentController.class);


	@Autowired
	private ComponentService componentService;

	@Autowired
	private ProductService productService;
	@Autowired
	private TplSetService tplSetService;
	@Autowired
	private ComponentTypeService componentTypeService;


	@Autowired
	private ComponentValidator componentValidator;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(componentValidator);
		webDataBinder.registerCustomEditor(Date.class, new DateConverter());
	}

	/**
	 * 新增组件
	 * @param componentAddDto
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增组件", httpMethod = "POST")
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
  	@BusinessFuncMonitor(value = "icode.project.component.add", count = true)
	public ComponentVO add(@RequestBody @Valid ComponentAddDto componentAddDto){
		Component component = new Component();
		BeanUtils.copyProperties(componentAddDto, component);

		componentService.add(component);

		return  initViewProperty(component);
	}

	/**
	 * 删除组件,id以逗号分隔
	 * @param idArray
	 */
	@ApiOperation(value = "删除", notes = "删除组件", httpMethod = "DELETE")
	@DeleteMapping(path="/{idArray}")
  	@BusinessFuncMonitor(value = "icode.project.component.delete", count = true)
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete component :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			componentService.delete(id);
		}

	}

	/**
	 * 更新组件
	 * @param componentEditDto
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改", notes = "修改组件(修改全部字段,未传入置空)", httpMethod = "PUT")
	@PutMapping(path="/{id}")
  	@BusinessFuncMonitor(value = "icode.project.component.update", count = true)
	public	ComponentVO update(@RequestBody @Valid ComponentEditDto componentEditDto, @PathVariable String id){
		Component component = componentService.find(id);
		BeanUtils.copyProperties(componentEditDto, component);
		component.setId(id);
		componentService.merge(component);

		ComponentVO vo = initViewProperty(component);
		return  vo;
	}

	/**
	 * 根据ID查询组件
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据ID查询组件", httpMethod = "GET")
	@GetMapping(path="/{id}")
  	@BusinessFuncMonitor(value = "icode.project.component.get")
	public  ComponentVO get(@PathVariable String id) {

		Component component = componentService.find(id);
		if(component == null){
			throw new ResourceNotFoundException("找不到指定的组件，请检查ID");
		}
		ComponentVO vo = initViewProperty(component);
		return vo;
	}

	/**
	 * 查询组件列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询组件列表", httpMethod = "POST")
	@PostMapping(path="/list")
	@BusinessFuncMonitor(value = "icode.project.component.list")
	public PageContent<ComponentVO> list(@RequestBody PageSearchRequest<ComponentCondition> pageSearchRequest){

		PageRequest pageRequest = PageRequestConvert.convert(pageSearchRequest);
      
		Page<Component> page = componentService.find(pageSearchRequest.getSearchCondition(), pageRequest);

		List<ComponentVO> voList = new ArrayList<>();
		for(Component component : page.getContent()){
			voList.add(initViewProperty(component));
		}

		PageContent<ComponentVO> pageContent = new PageContent<>(voList, page.getTotalElements());
		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}

	/**
     * 导出组件列表
     * @param condition
     * @param response
     */
    @ApiOperation(value = "导出", notes = "根据条件导出组件列表", httpMethod = "POST")
    @RequestMapping(path="/export")
    public void export(ComponentCondition condition, HttpServletResponse response) throws UnsupportedEncodingException {

        PageSearchRequest<ComponentCondition> pageSearchRequest = new PageSearchRequest<>();
        pageSearchRequest.setPage(0);
        pageSearchRequest.setLimit(Integer.MAX_VALUE);
        pageSearchRequest.setSearchCondition(condition);

        PageContent<ComponentVO> content = this.list(pageSearchRequest);

        List<ComponentVO> voList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(content.getContent())){
            voList.addAll(content.getContent());
        }

        JSONArray jsonArray = new JSONArray();
        for(ComponentVO vo : voList){
            jsonArray.add(vo);
        }

        Map<String,String> headMap = new LinkedHashMap<>();

        headMap.put("product" ,"所属产品");
        headMap.put("number" ,"组件编号");
        headMap.put("name" ,"组件名称");
        headMap.put("code" ,"组件代码");
        headMap.put("basePackage" ,"基础包");
        headMap.put("tplSet" ,"代码模板");
        headMap.put("description" ,"描述");
        headMap.put("type" ,"类型");
        headMap.put("runnable" ,"可运行组件");

        String title = new String("组件");
        String fileName = new String(("组件_"+ DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT.format(new Date())).getBytes("UTF-8"), "ISO-8859-1");
        ExcelUtil.downloadExcelFile(title, headMap, jsonArray, response, fileName);
    }

	private ComponentVO initViewProperty(Component component){

	    ComponentVO vo = new ComponentVO();
        BeanUtils.copyProperties(component, vo);


	    //初始化其他对象
	    initProductPropertyGroup(vo, component);
	    initTplSetPropertyGroup(vo, component);
	    initTypePropertyGroup(vo, component);
        return vo;

	}

	private void initProductPropertyGroup(ComponentVO componentVO, Component component){
	
		Product product = productService.find(component.getProduct());
		if(product == null){
			return;
		}
		ProductVO productVO = new ProductVO();
		BeanUtils.copyProperties(product, productVO);

		componentVO.setProductVO(productVO);

	}
	private void initTplSetPropertyGroup(ComponentVO componentVO, Component component){
	
		TplSet tplSet = tplSetService.find(component.getTplSet());
		if(tplSet == null){
			return;
		}
		TplSetVO tplSetVO = new TplSetVO();
		BeanUtils.copyProperties(tplSet, tplSetVO);

		componentVO.setTplSetVO(tplSetVO);

	}
	private void initTypePropertyGroup(ComponentVO componentVO, Component component){
	
		ComponentType type = componentTypeService.find(component.getType());
		if(type == null){
			return;
		}
		ComponentTypeVO typeVO = new ComponentTypeVO();
		BeanUtils.copyProperties(type, typeVO);

		componentVO.setTypeVO(typeVO);

	}

}
