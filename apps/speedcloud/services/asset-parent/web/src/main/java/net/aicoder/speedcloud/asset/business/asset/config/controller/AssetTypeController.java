package net.aicoder.speedcloud.asset.business.asset.config.controller;

import com.alibaba.fastjson.JSONArray;
import com.yunkang.saas.common.framework.spring.DateConverter;
import com.yunkang.saas.common.framework.web.ExcelUtil;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageRequest;
import com.yunkang.saas.common.framework.web.data.PageRequestConvert;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.aicoder.speedcloud.asset.business.asset.config.domain.AssetType;
import net.aicoder.speedcloud.asset.business.asset.config.dto.AssetTypeAddDto;
import net.aicoder.speedcloud.asset.business.asset.config.dto.AssetTypeCondition;
import net.aicoder.speedcloud.asset.business.asset.config.dto.AssetTypeEditDto;
import net.aicoder.speedcloud.asset.business.asset.config.service.AssetTypeService;
import net.aicoder.speedcloud.asset.business.asset.config.valid.AssetTypeValidator;
import net.aicoder.speedcloud.asset.business.asset.config.vo.AssetTypeVO;
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
 * 管理资产分类
 * @author icode
 */
@Api(description = "资产分类", tags = "AssetType")
@RestController
@RequestMapping(value = "/asset/asset/config/assettype")
public class AssetTypeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssetTypeController.class);


	@Autowired
	private AssetTypeService assetTypeService;



	@Autowired
	private AssetTypeValidator assetTypeValidator;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(assetTypeValidator);
		webDataBinder.registerCustomEditor(Date.class, new DateConverter());
	}

	/**
	 * 新增资产分类
	 * @param assetTypeAddDto
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增资产分类", httpMethod = "POST")
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	public AssetTypeVO add(@RequestBody @Valid AssetTypeAddDto assetTypeAddDto){
		AssetType assetType = new AssetType();
		BeanUtils.copyProperties(assetTypeAddDto, assetType);

		assetTypeService.add(assetType);

		return  initViewProperty(assetType);
	}

	/**
	 * 删除资产分类,id以逗号分隔
	 * @param idArray
	 */
	@ApiOperation(value = "删除", notes = "删除资产分类", httpMethod = "DELETE")
	@DeleteMapping(value="/{idArray}")
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete assetType :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			assetTypeService.delete(Long.parseLong(id));
		}

	}

	/**
	 * 更新资产分类
	 * @param assetTypeEditDto
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改", notes = "修改产资产分类(修改全部字段,未传入置空)", httpMethod = "PUT")
	@PutMapping(value="/{id}")
	public	AssetTypeVO update(@RequestBody @Valid AssetTypeEditDto assetTypeEditDto, @PathVariable Long id){
		AssetType assetType = new AssetType();
		BeanUtils.copyProperties(assetTypeEditDto, assetType);
		assetType.setId(id);
		assetTypeService.merge(assetType);

		AssetTypeVO vo = initViewProperty(assetType);
		return  vo;
	}

	/**
	 * 根据ID查询资产分类
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据ID查询资产分类", httpMethod = "GET")
	@GetMapping(value="/{id}")
	public  AssetTypeVO get(@PathVariable Long id) {

		AssetType assetType = assetTypeService.find(id);

		AssetTypeVO vo = initViewProperty(assetType);
		return vo;
	}

	/**
	 * 查询资产分类列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询资产分类列表", httpMethod = "POST")
	@PostMapping("/list")
	public PageContent<AssetTypeVO> list(@RequestBody PageSearchRequest<AssetTypeCondition> pageSearchRequest){

		PageRequest pageRequest = PageRequestConvert.convert(pageSearchRequest);
		Page<AssetType> page = assetTypeService.find(pageSearchRequest.getSearchCondition(), pageRequest);

		List<AssetTypeVO> voList = new ArrayList<>();
		for(AssetType assetType : page.getContent()){
			voList.add(initViewProperty(assetType));
		}

		PageContent<AssetTypeVO> pageContent = new PageContent<>(voList, page.getTotalElements());
		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}

	/**
     * 导出资产分类列表
     * @param condition
     * @param response
     */
    @ApiOperation(value = "导出", notes = "根据条件导出资产分类列表", httpMethod = "POST")
    @RequestMapping("/export")
    public void export(AssetTypeCondition condition, HttpServletResponse response) throws UnsupportedEncodingException {

        PageSearchRequest<AssetTypeCondition> pageSearchRequest = new PageSearchRequest<>();
        pageSearchRequest.setPage(0);
        pageSearchRequest.setLimit(Integer.MAX_VALUE);
        pageSearchRequest.setSearchCondition(condition);

        PageContent<AssetTypeVO> content = this.list(pageSearchRequest);

        List<AssetTypeVO> voList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(content.getContent())){
            voList.addAll(content.getContent());
        }

        JSONArray jsonArray = new JSONArray();
        for(AssetTypeVO vo : voList){
            jsonArray.add(vo);
        }

        Map<String,String> headMap = new LinkedHashMap<String,String>();

            headMap.put("tid" ,"租户id");
            headMap.put("num" ,"编号");
            headMap.put("name" ,"名称");
            headMap.put("code" ,"代码");
            headMap.put("useMonth" ,"年限(月)");
            headMap.put("viewIndex" ,"展现顺序");
            headMap.put("parentCode" ,"上级代码");
            headMap.put("description" ,"说明");
            headMap.put("assetCategoryCode" ,"所属大类");

        String title = new String("资产分类");
        String fileName = new String(("资产分类_"+ DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT.format(new Date())).getBytes("UTF-8"), "ISO-8859-1");
        ExcelUtil.downloadExcelFile(title, headMap, jsonArray, response, fileName);
    }

	private AssetTypeVO initViewProperty(AssetType assetType){

	    AssetTypeVO vo = new AssetTypeVO();
        BeanUtils.copyProperties(assetType, vo);


	    //初始化其他对象
        return vo;

	}


}

