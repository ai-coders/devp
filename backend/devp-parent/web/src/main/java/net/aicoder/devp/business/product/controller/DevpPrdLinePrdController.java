package net.aicoder.devp.business.product.controller;

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
import net.aicoder.devp.business.product.domain.DevpPrdLinePrd;
import net.aicoder.devp.business.product.dto.DevpPrdLinePrdCondition;
import net.aicoder.devp.business.product.dto.DevpPrdLinePrdAddDto;
import net.aicoder.devp.business.product.dto.DevpPrdLinePrdEditDto;
import net.aicoder.devp.business.product.service.DevpPrdLinePrdService;
import net.aicoder.devp.business.product.valid.DevpPrdLinePrdValidator;
import net.aicoder.devp.business.product.vo.DevpPrdLinePrdVO;

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
 * 管理产品所属产品线
 * @author icode
 */
@Api(description = "产品所属产品线", tags = "DevpPrdLinePrd")
@RestController
@RequestMapping(value = "/product/devpPrdLinePrd")
public class DevpPrdLinePrdController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevpPrdLinePrdController.class);


	@Autowired
	private DevpPrdLinePrdService devpPrdLinePrdService;


	@Autowired
	private DevpPrdLinePrdValidator devpPrdLinePrdValidator;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(devpPrdLinePrdValidator);
		webDataBinder.registerCustomEditor(Date.class, new DateConverter());
	}

	/**
	 * 新增产品所属产品线
	 * @param devpPrdLinePrdAddDto
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增产品所属产品线", httpMethod = "POST")
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	public DevpPrdLinePrdVO add(@RequestBody @Valid DevpPrdLinePrdAddDto devpPrdLinePrdAddDto){
		DevpPrdLinePrd devpPrdLinePrd = new DevpPrdLinePrd();
		BeanUtils.copyProperties(devpPrdLinePrdAddDto, devpPrdLinePrd);

		devpPrdLinePrdService.add(devpPrdLinePrd);

		return  initViewProperty(devpPrdLinePrd);
	}

	/**
	 * 删除产品所属产品线,id以逗号分隔
	 * @param idArray
	 */
	@ApiOperation(value = "删除", notes = "删除产品所属产品线", httpMethod = "DELETE")
	@DeleteMapping(value="/{idArray}")
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete devpPrdLinePrd :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			devpPrdLinePrdService.delete(Long.parseLong(id));
		}

	}

	/**
	 * 更新产品所属产品线
	 * @param devpPrdLinePrdEditDto
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改", notes = "修改产产品所属产品线(修改全部字段,未传入置空)", httpMethod = "PUT")
	@PutMapping(value="/{id}")
	public	DevpPrdLinePrdVO update(@RequestBody @Valid DevpPrdLinePrdEditDto devpPrdLinePrdEditDto, @PathVariable Long id){
		DevpPrdLinePrd devpPrdLinePrd = new DevpPrdLinePrd();
		BeanUtils.copyProperties(devpPrdLinePrdEditDto, devpPrdLinePrd);
		devpPrdLinePrd.setId(id);
		devpPrdLinePrdService.merge(devpPrdLinePrd);

		DevpPrdLinePrdVO vo = initViewProperty(devpPrdLinePrd);
		return  vo;
	}

	/**
	 * 根据ID查询产品所属产品线
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据ID查询产品所属产品线", httpMethod = "GET")
	@GetMapping(value="/{id}")
	public  DevpPrdLinePrdVO get(@PathVariable Long id) {

		DevpPrdLinePrd devpPrdLinePrd = devpPrdLinePrdService.find(id);

		DevpPrdLinePrdVO vo = initViewProperty(devpPrdLinePrd);
		return vo;
	}

	/**
	 * 查询产品所属产品线列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询产品所属产品线列表", httpMethod = "POST")
	@PostMapping("/list")
	public PageContent<DevpPrdLinePrdVO> list(@RequestBody PageSearchRequest<DevpPrdLinePrdCondition> pageSearchRequest){

		PageRequest pageRequest = PageRequestConvert.convert(pageSearchRequest);

		Page<DevpPrdLinePrd> page = devpPrdLinePrdService.find(pageSearchRequest.getSearchCondition(), pageRequest);

		List<DevpPrdLinePrdVO> voList = new ArrayList<>();
		for(DevpPrdLinePrd devpPrdLinePrd : page.getContent()){
			voList.add(initViewProperty(devpPrdLinePrd));
		}

		PageContent<DevpPrdLinePrdVO> pageContent = new PageContent<>(voList, page.getTotalElements());
		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}

	/**
     * 导出产品所属产品线列表
     * @param condition
     * @param response
     */
    @ApiOperation(value = "导出", notes = "根据条件导出产品所属产品线列表", httpMethod = "POST")
    @RequestMapping("/export")
    public void export(DevpPrdLinePrdCondition condition, HttpServletResponse response) throws UnsupportedEncodingException {

        PageSearchRequest<DevpPrdLinePrdCondition> pageSearchRequest = new PageSearchRequest<>();
        pageSearchRequest.setPage(0);
        pageSearchRequest.setLimit(Integer.MAX_VALUE);
        pageSearchRequest.setSearchCondition(condition);

        PageContent<DevpPrdLinePrdVO> content = this.list(pageSearchRequest);

        List<DevpPrdLinePrdVO> voList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(content.getContent())){
            voList.addAll(content.getContent());
        }

        JSONArray jsonArray = new JSONArray();
        for(DevpPrdLinePrdVO vo : voList){
            jsonArray.add(vo);
        }

        Map<String,String> headMap = new LinkedHashMap<String,String>();

            headMap.put("tid" ,"租户编号");
            headMap.put("etype" ,"etype");
            headMap.put("code" ,"代码");
            headMap.put("name" ,"名称");
            headMap.put("alias" ,"别名");
            headMap.put("description" ,"描述");
            headMap.put("lineRid" ,"产品线编号");
            headMap.put("prdRid" ,"产品编号");
            headMap.put("seq" ,"顺序号");
            headMap.put("type" ,"类型");
            headMap.put("stereotype" ,"构造型");
            headMap.put("scope" ,"范围");
            headMap.put("recordState" ,"记录状态");
            headMap.put("createUcode" ,"创建用户代码");
            headMap.put("createUname" ,"创建用户姓名");
            headMap.put("modifyUcode" ,"修改用户代码");
            headMap.put("modifyUname" ,"修改用户姓名");

        String title = new String("产品所属产品线");
        String fileName = new String(("产品所属产品线_"+ DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT.format(new Date())).getBytes("UTF-8"), "ISO-8859-1");
        ExcelUtil.downloadExcelFile(title, headMap, jsonArray, response, fileName);
    }

	private DevpPrdLinePrdVO initViewProperty(DevpPrdLinePrd devpPrdLinePrd){

	    DevpPrdLinePrdVO vo = new DevpPrdLinePrdVO();
        BeanUtils.copyProperties(devpPrdLinePrd, vo);


	    //初始化其他对象
        return vo;


	}


}
