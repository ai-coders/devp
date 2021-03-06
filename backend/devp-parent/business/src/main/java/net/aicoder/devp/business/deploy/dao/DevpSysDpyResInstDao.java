package net.aicoder.devp.business.deploy.dao;

import com.yunkang.saas.common.jpa.BaseDao;
import net.aicoder.devp.business.deploy.domain.DevpSysDpyResInst;
import org.springframework.stereotype.Repository;



/**
 * 部署关联资源实例的数据库操作
 * @author icode
 */
@Repository("devpSysDpyResInstDao")
public interface DevpSysDpyResInstDao extends BaseDao<DevpSysDpyResInst, Long>{


}
