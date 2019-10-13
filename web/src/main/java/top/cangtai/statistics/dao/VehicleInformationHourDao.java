/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.statistics.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import top.cangtai.statistics.entity.QueryCriteria;
import top.cangtai.statistics.entity.VehicleInformationHour;

import java.util.List;

/**
 * 统计DAO接口
 * @author majunlong
 * @version 2019-04-19
 */
@MyBatisDao
public interface VehicleInformationHourDao extends CrudDao<VehicleInformationHour> {

	List<VehicleInformationHour> findAllVehicleInformation(@Param("queryCriteria") QueryCriteria queryCriteria);

}