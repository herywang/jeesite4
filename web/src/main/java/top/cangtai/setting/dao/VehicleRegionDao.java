/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.setting.dao;

import org.springframework.data.mongodb.core.query.Query;
import top.cangtai.setting.entity.VehicleRegion;

import java.util.List;

/**
 * 区域设置DAO接口
 * @author majunlong
 * @version 2019-04-18
 */
public interface VehicleRegionDao {

    VehicleRegion findOneByVehicleRegion();

    void addVehicleRegion(VehicleRegion vehicleRegion);

    List<VehicleRegion> findVehicleRegionByPage(Query query, Integer pageOn);

    long count(Query query);

    void deleteById(String id);
}