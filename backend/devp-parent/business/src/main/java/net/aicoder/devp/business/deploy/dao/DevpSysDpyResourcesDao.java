package net.aicoder.devp.business.deploy.dao;

import com.yunkang.saas.common.jpa.BaseDao;
import net.aicoder.devp.business.deploy.domain.DevpSysDpyResources;
import org.springframework.stereotype.Repository;



/**
 * 部署关联资源的数据库操作
 * @author icode
 */
@Repository("devpSysDpyResourcesDao")
public interface DevpSysDpyResourcesDao extends BaseDao<DevpSysDpyResources, Long>{


}
