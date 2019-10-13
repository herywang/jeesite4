/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.statistics.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import top.cangtai.statistics.entity.QueryCriteria;
import top.cangtai.statistics.entity.VehicleInformationDay;

import java.util.List;

/**
 * 自定义统计DAO接口
 * @author majunlong
 * @version 2019-04-19
 */
@MyBatisDao
public interface VehicleInformationDayDao extends CrudDao<VehicleInformationDay> {

    List<VehicleInformationDay> findAllVehicleInformationByDay(@Param("queryCriteria") QueryCriteria queryCriteria);

    List<VehicleInformationDay> findAllVehicleInformationByMonth(@Param("queryCriteria") QueryCriteria queryCriteria);

    List<VehicleInformationDay> findAllVehicleInformationByYear(@Param("queryCriteria") QueryCriteria queryCriteria);

    List<VehicleInformationDay> findAllVehicleInformationByWeek(@Param("queryCriteria") QueryCriteria queryCriteria);
}