package net.aicoder.devp.business.sys.controller;

import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageRequest;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import com.yunkang.saas.common.framework.web.data.SortCondition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.aicoder.devp.business.sys.domain.DevpSysCmp;
import net.aicoder.devp.business.sys.dto.DevpSysCmpAddDto;
import net.aicoder.devp.business.sys.dto.DevpSysCmpCondition;
import net.aicoder.devp.business.sys.dto.DevpSysCmpEditDto;
import net.aicoder.devp.business.sys.service.DevpSysCmpService;
import net.aicoder.devp.business.sys.valid.DevpSysCmpValidator;
import net.aicoder.devp.business.sys.vo.DevpSysCmpVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理系统组件
 * @author icode
 */
@Api(description = "系统组件", tags = "DevpSysCmp")
@RestController
@RequestMapping(value = "/sys/devpSysCmp")
public class DevpSysCmpController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevpSysCmpController.class);


	@Autowired
	private DevpSysCmpService devpSysCmpService;


	@Autowired
	private DevpSysCmpValidator devpSysCmpValidator;

    @InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(devpSysCmpValidator);
	}

	/**
	 * 新增系统组件
	 * @param devpSysCmpAddDto
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增系统组件", httpMethod = "POST")
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	public DevpSysCmpVO add(@RequestBody @Valid DevpSysCmpAddDto devpSysCmpAddDto){
		DevpSysCmp devpSysCmp = new DevpSysCmp();
		BeanUtils.copyProperties(devpSysCmpAddDto, devpSysCmp);

		devpSysCmpService.add(devpSysCmp);

		return  initViewProperty(devpSysCmp);
	}

	/**
	 * 删除系统组件,id以逗号分隔
	 * @param idArray
	 */
	@ApiOperation(value = "删除", notes = "删除系统组件", httpMethod = "DELETE")
	@DeleteMapping(value="/{idArray}")
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete devpSysCmp :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			devpSysCmpService.delete(Long.parseLong(id));
		}

	}

	/**
	 * 更新系统组件
	 * @param devpSysCmpEditDto
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改", notes = "修改产系统组件(修改全部字段,未传入置空)", httpMethod = "PUT")
	@PutMapping(value="/{id}")
	public	DevpSysCmpVO update(@RequestBody @Valid DevpSysCmpEditDto devpSysCmpEditDto, @PathVariable Long id){
		DevpSysCmp devpSysCmp = new DevpSysCmp();
		BeanUtils.copyProperties(devpSysCmpEditDto, devpSysCmp);
		devpSysCmp.setId(id);
		devpSysCmpService.merge(devpSysCmp);

		DevpSysCmpVO vo = initViewProperty(devpSysCmp);
		return  vo;
	}

	/**
	 * 根据ID查询系统组件
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据ID查询系统组件", httpMethod = "GET")
	@GetMapping(value="/{id}")
	public  DevpSysCmpVO get(@PathVariable Long id) {

		DevpSysCmp devpSysCmp = devpSysCmpService.find(id);

		DevpSysCmpVO vo = initViewProperty(devpSysCmp);
		return vo;
	}

	/**
	 * 查询系统组件列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询系统组件列表", httpMethod = "POST")
	@PostMapping("/list")
	public PageContent<DevpSysCmpVO> list(@RequestBody PageSearchRequest<DevpSysCmpCondition> pageSearchRequest){

		SortCondition sortCondition = pageSearchRequest.getSortCondition();
		Sort sort   = null;
		if(sortCondition!=null){
			sort = new Sort(Sort.Direction.fromStringOrNull(sortCondition.getDirection().toString()), sortCondition.getProperty());
		}
		PageRequest pageRequest = new PageRequest(pageSearchRequest.getPage(), pageSearchRequest.getLimit());
		pageRequest.setSort(sort);
		Page<DevpSysCmp> page = devpSysCmpService.find(pageSearchRequest.getSearchCondition(), pageRequest);

		List<DevpSysCmpVO> voList = new ArrayList<>();
		for(DevpSysCmp devpSysCmp : page.getContent()){
			voList.add(initViewProperty(devpSysCmp));
		}

		PageContent<DevpSysCmpVO> pageContent = new PageContent<>(voList, page.getTotalElements());
		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}

	private DevpSysCmpVO initViewProperty(DevpSysCmp devpSysCmp){
	    DevpSysCmpVO vo = new DevpSysCmpVO();

        BeanUtils.copyProperties(devpSysCmp, vo);

	    //初始化其他对象
        return vo;
	}


}