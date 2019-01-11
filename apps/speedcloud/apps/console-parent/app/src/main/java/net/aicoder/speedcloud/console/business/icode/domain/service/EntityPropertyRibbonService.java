package net.aicoder.speedcloud.console.business.icode.domain.service;

import com.yunkang.saas.common.framework.exception.BusinessException;
import com.yunkang.saas.common.framework.web.controller.PageContent;
import com.yunkang.saas.common.framework.web.data.PageSearchRequest;
import net.aicoder.speedcloud.icode.business.domain.dto.EntityPropertyAddDto;
import net.aicoder.speedcloud.icode.business.domain.dto.EntityPropertyCondition;
import net.aicoder.speedcloud.icode.business.domain.dto.EntityPropertyEditDto;
import net.aicoder.speedcloud.icode.business.domain.vo.EntityPropertyVO;
import net.aicoder.speedcloud.icode.client.domain.EntityPropertyRibbon;
import net.aicoder.speedcloud.icode.client.domain.result.EntityPropertyPageResult;
import net.aicoder.speedcloud.icode.client.domain.result.EntityPropertyResult;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("entityPropertyRibbonService")
public class EntityPropertyRibbonService  {

	private static final Logger LOGGER = LoggerFactory.getLogger(EntityPropertyRibbonService.class);


	@Autowired
	private EntityPropertyRibbon entityPropertyRibbon;


	public EntityPropertyVO add(EntityPropertyAddDto addDto){
		EntityPropertyResult result = entityPropertyRibbon.add(addDto);

		if(!result.isSuccess()){
			throw new BusinessException("ICODE", "DOMAIN", result.getCode()+"", result.getMessage());
		}
		return result.getData();
	
	}

	public void delete(String id){
		if(null == id){
			LOGGER.warn("try delete T by empty id. Code need check");
			return ;
		}
		LOGGER.debug("delete t:{}", id);
		EntityPropertyResult result = entityPropertyRibbon.delete(id);
		if(!result.isSuccess()){
			throw new BusinessException("ICODE", "DOMAIN", result.getCode()+"", result.getMessage());
		}
	}
	public EntityPropertyVO merge(String id, EntityPropertyEditDto editDto){
		EntityPropertyResult result = entityPropertyRibbon.update(id, editDto);

		if(!result.isSuccess()){
			throw new BusinessException("ICODE", "DOMAIN", result.getCode()+"", result.getMessage());
		}

		return result.getData();
	}
	public EntityPropertyVO find(String id){
		EntityPropertyResult result = entityPropertyRibbon.get(id);

		if(!result.isSuccess()){
			throw new BusinessException("ICODE", "DOMAIN", result.getCode()+"", result.getMessage());
		}

		return result.getData();
	}

	public PageContent<EntityPropertyVO> list(PageSearchRequest<EntityPropertyCondition> pageSearchRequest) {
		EntityPropertyPageResult result = entityPropertyRibbon.list(pageSearchRequest);

		if(!result.isSuccess()){
			throw new BusinessException("ICODE", "DOMAIN", result.getCode()+"", result.getMessage());
		}

		return result.getData();
	}

	public List<EntityPropertyVO> list(EntityPropertyCondition condition) {
		PageSearchRequest request = new PageSearchRequest();
		request.setPage(0);
		request.setLimit(Integer.MAX_VALUE);
		request.setSearchCondition(condition);
		PageContent<EntityPropertyVO> result = list(request);

		return result.getContent();
	}

	public EntityPropertyVO findPrimaryKeyFormModel(String modelId){
		EntityPropertyCondition condition = new EntityPropertyCondition();
		condition.setEntity(modelId);
		condition.setPrimaryKey(true);

		List<EntityPropertyVO> list = this.list(condition);
		EntityPropertyVO result = null;
		if(CollectionUtils.size(list) >0){
			result = list.get(0);
		}

		return result;
	}
}