package com.yunkang.saas.platform.monitor.business.monitor.app.controller;

import com.yunkang.saas.bootstrap.application.business.annotation.SaaSAnnotation;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageRequest;
import com.yunkang.saas.common.framework.web.data.PageRequestConvert;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import com.yunkang.saas.platform.monitor.business.app.domain.UnknownApp;
import com.yunkang.saas.platform.monitor.business.app.dto.UnknownAppAddDto;
import com.yunkang.saas.platform.monitor.business.app.dto.UnknownAppCondition;
import com.yunkang.saas.platform.monitor.business.app.dto.UnknownAppEditDto;
import com.yunkang.saas.platform.monitor.business.app.service.UnknownAppService;
import com.yunkang.saas.platform.monitor.business.app.valid.UnknownAppValidator;
import com.yunkang.saas.platform.monitor.business.app.vo.UnknownAppVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理未知程序
 * @author icode
 */
@Api(description = "未知程序", tags = "UnknownApp")
@RestController
@RequestMapping(value =  "/monitor/app/unknownapp")
public class UnknownAppController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UnknownAppController.class);

	@Autowired
	private UnknownAppService unknownAppService;


	@Autowired
	private UnknownAppValidator unknownAppValidator;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(unknownAppValidator);
	}

	/**
	 * 新增未知程序
	 * @param unknownAppAddDto
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增未知程序", httpMethod = "POST")
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
    @SaaSAnnotation
	public UnknownAppVO add(@RequestBody @Valid UnknownAppAddDto unknownAppAddDto){

		UnknownApp unknownApp = new UnknownApp();
		BeanUtils.copyProperties(unknownAppAddDto, unknownApp);
		unknownAppService.add(unknownApp);

		return  initViewProperty(unknownApp);
	}

	/**
	 * 删除未知程序,id以逗号分隔
	 * @param idArray
	 */
	@ApiOperation(value = "删除", notes = "删除未知程序", httpMethod = "DELETE")
	@DeleteMapping(path="/{idArray}")
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete unknownApp :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			unknownAppService.delete(id);
		}

	}

	/**
	 * 更新未知程序
	 * @param unknownAppEditDto
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改", notes = "修改产未知程序(修改全部字段,未传入置空)", httpMethod = "PUT")
	@PutMapping(path="/{id}")
	public	UnknownAppVO update(@RequestBody @Valid UnknownAppEditDto unknownAppEditDto, @PathVariable String id){
		UnknownApp unknownApp = new UnknownApp();
		BeanUtils.copyProperties(unknownAppEditDto, unknownApp);
		unknownApp.setId(id);
		unknownAppService.merge(unknownApp);

		UnknownAppVO vo = initViewProperty(unknownApp);
		return  vo;
	}

	/**
	 * 根据ID查询未知程序
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据ID查询未知程序", httpMethod = "GET")
	@GetMapping(path="/{id}")
	public  UnknownAppVO get(@PathVariable String id) {

		UnknownApp unknownApp = unknownAppService.find(id);

		UnknownAppVO vo = initViewProperty(unknownApp);
		return vo;
	}

	/**
	 * 查询未知程序列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询未知程序列表", httpMethod = "POST")
	@PostMapping(path="/list")
	@SaaSAnnotation(conditionClass = UnknownAppCondition.class)
	public PageContent<UnknownAppVO> list(@RequestBody PageSearchRequest<UnknownAppCondition> pageSearchRequest){

		PageRequest pageRequest = PageRequestConvert.convert(pageSearchRequest);
		
		Page<UnknownApp> page = unknownAppService.find(pageSearchRequest.getSearchCondition(), pageRequest);

		List<UnknownAppVO> voList = new ArrayList<>();
		for(UnknownApp unknownApp : page.getContent()){
			voList.add(initViewProperty(unknownApp));
		}

		PageContent<UnknownAppVO> pageContent = new PageContent<>(voList, page.getTotalElements());
		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}

	private UnknownAppVO initViewProperty(UnknownApp unknownApp){

	    UnknownAppVO vo = new UnknownAppVO();
        BeanUtils.copyProperties(unknownApp, vo);


	    //初始化其他对象
        return vo;


	}


}
