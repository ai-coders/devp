package net.aicoder.devp.business.sys.controller;

import com.yunkang.saas.common.framework.spring.DateConverter;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageRequest;
import com.yunkang.saas.common.framework.web.data.PageRequestConvert;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import com.yunkang.saas.common.framework.web.data.SortCondition;
import com.yunkang.saas.common.framework.web.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.aicoder.devp.business.sys.domain.DevpSysIdeRef;
import net.aicoder.devp.business.sys.dto.DevpSysIdeRefCondition;
import net.aicoder.devp.business.sys.dto.DevpSysIdeRefAddDto;
import net.aicoder.devp.business.sys.dto.DevpSysIdeRefEditDto;
import net.aicoder.devp.business.sys.service.DevpSysIdeRefService;
import net.aicoder.devp.business.sys.valid.DevpSysIdeRefValidator;
import net.aicoder.devp.business.sys.vo.DevpSysIdeRefVO;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.WebDataBinder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 管理开发工程引用组件
 * @author icode
 */
@Api(description = "开发工程引用组件", tags = "DevpSysIdeRef")
@RestController
@RequestMapping(value = "/sys/devpSysIdeRef")
public class DevpSysIdeRefController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevpSysIdeRefController.class);


	@Autowired
	private DevpSysIdeRefService devpSysIdeRefService;


	@Autowired
	private DevpSysIdeRefValidator devpSysIdeRefValidator;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(devpSysIdeRefValidator);
		webDataBinder.registerCustomEditor(Date.class, new DateConverter());
	}

	/**
	 * 新增开发工程引用组件
	 * @param devpSysIdeRefAddDto
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增开发工程引用组件", httpMethod = "POST")
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	public DevpSysIdeRefVO add(@RequestBody @Valid DevpSysIdeRefAddDto devpSysIdeRefAddDto){
		DevpSysIdeRef devpSysIdeRef = new DevpSysIdeRef();
		BeanUtils.copyProperties(devpSysIdeRefAddDto, devpSysIdeRef);

		devpSysIdeRefService.add(devpSysIdeRef);

		return  initViewProperty(devpSysIdeRef);
	}

	/**
	 * 删除开发工程引用组件,id以逗号分隔
	 * @param idArray
	 */
	@ApiOperation(value = "删除", notes = "删除开发工程引用组件", httpMethod = "DELETE")
	@DeleteMapping(value="/{idArray}")
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete devpSysIdeRef :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			devpSysIdeRefService.delete(Long.parseLong(id));
		}

	}

	/**
	 * 更新开发工程引用组件
	 * @param devpSysIdeRefEditDto
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改", notes = "修改产开发工程引用组件(修改全部字段,未传入置空)", httpMethod = "PUT")
	@PutMapping(value="/{id}")
	public	DevpSysIdeRefVO update(@RequestBody @Valid DevpSysIdeRefEditDto devpSysIdeRefEditDto, @PathVariable Long id){
		DevpSysIdeRef devpSysIdeRef = new DevpSysIdeRef();
		BeanUtils.copyProperties(devpSysIdeRefEditDto, devpSysIdeRef);
		devpSysIdeRef.setId(id);
		devpSysIdeRefService.merge(devpSysIdeRef);

		DevpSysIdeRefVO vo = initViewProperty(devpSysIdeRef);
		return  vo;
	}

	/**
	 * 根据ID查询开发工程引用组件
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据ID查询开发工程引用组件", httpMethod = "GET")
	@GetMapping(value="/{id}")
	public  DevpSysIdeRefVO get(@PathVariable Long id) {

		DevpSysIdeRef devpSysIdeRef = devpSysIdeRefService.find(id);

		DevpSysIdeRefVO vo = initViewProperty(devpSysIdeRef);
		return vo;
	}

	/**
	 * 查询开发工程引用组件列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询开发工程引用组件列表", httpMethod = "POST")
	@PostMapping("/list")
	public PageContent<DevpSysIdeRefVO> list(@RequestBody PageSearchRequest<DevpSysIdeRefCondition> pageSearchRequest){

		PageRequest pageRequest = PageRequestConvert.convert(pageSearchRequest);

		Page<DevpSysIdeRef> page = devpSysIdeRefService.find(pageSearchRequest.getSearchCondition(), pageRequest);

		List<DevpSysIdeRefVO> voList = new ArrayList<>();
		for(DevpSysIdeRef devpSysIdeRef : page.getContent()){
			voList.add(initViewProperty(devpSysIdeRef));
		}

		PageContent<DevpSysIdeRefVO> pageContent = new PageContent<>(voList, page.getTotalElements());
		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}

	/**
     * 导出开发工程引用组件列表
     * @param condition
     * @param response
     */
    @ApiOperation(value = "导出", notes = "根据条件导出开发工程引用组件列表", httpMethod = "POST")
    @RequestMapping("/export")
    public void export(DevpSysIdeRefCondition condition, HttpServletResponse response) throws UnsupportedEncodingException {

        PageSearchRequest<DevpSysIdeRefCondition> pageSearchRequest = new PageSearchRequest<>();
        pageSearchRequest.setPage(0);
        pageSearchRequest.setLimit(Integer.MAX_VALUE);
        pageSearchRequest.setSearchCondition(condition);

        PageContent<DevpSysIdeRefVO> content = this.list(pageSearchRequest);

        List<DevpSysIdeRefVO> voList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(content.getContent())){
            voList.addAll(content.getContent());
        }

        JSONArray jsonArray = new JSONArray();
        for(DevpSysIdeRefVO vo : voList){
            jsonArray.add(vo);
        }

        Map<String,String> headMap = new LinkedHashMap<String,String>();

            headMap.put("tid" ,"租户编号");
            headMap.put("etype" ,"元素类型");
            headMap.put("name" ,"系统元素名称");
            headMap.put("code" ,"系统元素代码");
            headMap.put("alias" ,"系统元素别名");
            headMap.put("description" ,"系统元素描述");
            headMap.put("recordState" ,"记录状态");
            headMap.put("type" ,"类型");
            headMap.put("subType" ,"子类型");
            headMap.put("version" ,"版本");
            headMap.put("prdRid" ,"产品编号");
            headMap.put("ideRid" ,"开发工程编号");
            headMap.put("seq" ,"顺序号");
            headMap.put("nexusEtype" ,"关联记录类型");
            headMap.put("refPrdRid" ,"关联产品编号");
            headMap.put("refElmRid" ,"关联元素编号");
            headMap.put("createUcode" ,"创建用户代码");
            headMap.put("createUname" ,"创建用户姓名");
            headMap.put("modifyUcode" ,"修改用户代码");
            headMap.put("modifyUname" ,"修改用户姓名");

        String title = new String("开发工程引用组件");
        String fileName = new String(("开发工程引用组件_"+ DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT.format(new Date())).getBytes("UTF-8"), "ISO-8859-1");
        ExcelUtil.downloadExcelFile(title, headMap, jsonArray, response, fileName);
    }

	private DevpSysIdeRefVO initViewProperty(DevpSysIdeRef devpSysIdeRef){

	    DevpSysIdeRefVO vo = new DevpSysIdeRefVO();
        BeanUtils.copyProperties(devpSysIdeRef, vo);


	    //初始化其他对象
        return vo;


	}


}
