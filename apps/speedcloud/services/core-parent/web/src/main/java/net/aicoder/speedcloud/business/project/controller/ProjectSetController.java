package net.aicoder.speedcloud.business.project.controller;

import com.yunkang.saas.common.framework.spring.DateConverter;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageRequest;
import com.yunkang.saas.common.framework.web.data.PageRequestConvert;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.aicoder.speedcloud.business.project.domain.ProjectSet;
import net.aicoder.speedcloud.business.project.dto.ProjectSetAddDto;
import net.aicoder.speedcloud.business.project.dto.ProjectSetCondition;
import net.aicoder.speedcloud.business.project.dto.ProjectSetEditDto;
import net.aicoder.speedcloud.business.project.service.ProjectSetService;
import net.aicoder.speedcloud.business.project.valid.ProjectSetValidator;
import net.aicoder.speedcloud.business.project.vo.ProjectSetVO;
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
import java.util.Date;
import java.util.List;

/**
 * 管理项目集
 * @author icode
 */
@Api(description = "项目集", tags = "ProjectSet")
@RestController
@RequestMapping(value = "/speedcloud/project/projectset")
public class ProjectSetController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectSetController.class);


	@Autowired
	private ProjectSetService projectSetService;


	@Autowired
	private ProjectSetValidator projectSetValidator;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(projectSetValidator);
		webDataBinder.registerCustomEditor(Date.class, new DateConverter());
	}

	/**
	 * 新增项目集
	 * @param projectSetAddDto
	 * @return
	 */
	@ApiOperation(value = "新增", notes = "新增项目集", httpMethod = "POST")
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	public ProjectSetVO add(@RequestBody @Valid ProjectSetAddDto projectSetAddDto){
		ProjectSet projectSet = new ProjectSet();
		BeanUtils.copyProperties(projectSetAddDto, projectSet);

		projectSetService.add(projectSet);

		return  initViewProperty(projectSet);
	}

	/**
	 * 删除项目集,id以逗号分隔
	 * @param idArray
	 */
	@ApiOperation(value = "删除", notes = "删除项目集", httpMethod = "DELETE")
	@DeleteMapping(value="/{idArray}")
	public void delete(@PathVariable String idArray){

	    LOGGER.debug("delete projectSet :{}", idArray);

		String[] ids = idArray.split(",");
		for (String id : ids ){
			projectSetService.delete(id);
		}

	}

	/**
	 * 更新项目集
	 * @param projectSetEditDto
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改", notes = "修改产项目集(修改全部字段,未传入置空)", httpMethod = "PUT")
	@PutMapping(value="/{id}")
	public	ProjectSetVO update(@RequestBody @Valid ProjectSetEditDto projectSetEditDto, @PathVariable String id){
		ProjectSet projectSet = new ProjectSet();
		BeanUtils.copyProperties(projectSetEditDto, projectSet);
		projectSet.setId(id);
		projectSetService.merge(projectSet);

		ProjectSetVO vo = initViewProperty(projectSet);
		return  vo;
	}

	/**
	 * 根据ID查询项目集
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据ID查询项目集", httpMethod = "GET")
	@GetMapping(value="/{id}")
	public  ProjectSetVO get(@PathVariable String id) {

		ProjectSet projectSet = projectSetService.find(id);

		ProjectSetVO vo = initViewProperty(projectSet);
		return vo;
	}

	/**
	 * 查询项目集列表
	 * @param pageSearchRequest
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据条件查询项目集列表", httpMethod = "POST")
	@PostMapping("/list")
	public PageContent<ProjectSetVO> list(@RequestBody PageSearchRequest<ProjectSetCondition> pageSearchRequest){

		PageRequest pageRequest = PageRequestConvert.convert(pageSearchRequest);

		Page<ProjectSet> page = projectSetService.find(pageSearchRequest.getSearchCondition(), pageRequest);

		List<ProjectSetVO> voList = new ArrayList<>();
		for(ProjectSet projectSet : page.getContent()){
			voList.add(initViewProperty(projectSet));
		}

		PageContent<ProjectSetVO> pageContent = new PageContent<>(voList, page.getTotalElements());
		LOGGER.debug("page Size :{}, total:{}", pageContent.getContent().size() ,pageContent.getTotal());
		return pageContent;

	}

	private ProjectSetVO initViewProperty(ProjectSet projectSet){

	    ProjectSetVO vo = new ProjectSetVO();
        BeanUtils.copyProperties(projectSet, vo);


	    //初始化其他对象
        return vo;


	}


}
