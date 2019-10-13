/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.owner.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import top.cangtai.owner.entity.OwnerInformation;

/**
 * 所有车辆DAO接口
 * @author majunlong
 * @version 2019-04-18
 */
@MyBatisDao
public interface OwnerInformationDao extends CrudDao<OwnerInformation> {
	
}