/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.setting.service;

import com.jeesite.common.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import top.cangtai.setting.dao.VehicleRegionDao;
import top.cangtai.setting.entity.VehicleRegion;

import java.util.Date;
import java.util.List;


/**
 * 区域设置Service
 * @author majunlong
 * @version 2019-04-18
 */
@Service
public class VehicleRegionServiceImp implements VehicleRegionService {

	@Autowired
	private VehicleRegionDao vehicleRegionDao;
	@Value("${region.longitude}")
	private Double longitude;

	@Value("${region.dimension}")
	private Double dimension;

	@Value("${region.radius}")
	private Double radius;

	@Override
	public VehicleRegion findOneByVehicleRegion(){
		VehicleRegion vehicleRegion = vehicleRegionDao.findOneByVehicleRegion();
		if (vehicleRegion==null){
			vehicleRegion = addVehicleRegion(longitude,dimension,radius);
		}
		return vehicleRegion;
	}

	@Override
	public VehicleRegion addVehicleRegion(Double longitude, Double dimension, Double radius){
		VehicleRegion vehicleRegion = new VehicleRegion(longitude, dimension, radius);
		vehicleRegionDao.addVehicleRegion(vehicleRegion);
		return vehicleRegion;
	}

	@Override
	public VehicleRegion addVehicleRegion(Double longitude, Double dimension){
		VehicleRegion vehicleRegion = new VehicleRegion(longitude, dimension, findOneByVehicleRegion().getRadius());
		vehicleRegionDao.addVehicleRegion(vehicleRegion);
		return vehicleRegion;
	}

	@Override
	public Page<VehicleRegion> findPage(VehicleRegion vehicleRegion) {
		Page<VehicleRegion> page = (Page<VehicleRegion>) vehicleRegion.getPage();
		Query query = vehicleRegion.getQuery(page.getOrderBy());
		List<VehicleRegion> vehicleRegions = vehicleRegionDao.findVehicleRegionByPage(query, page.getPageNo());
		long count = vehicleRegionDao.count(query);
		page.setList(vehicleRegions);
		page.setCount(count);
		return page;
	}

	@Override
	public void addVehicleRegion(VehicleRegion vehicleRegion) {
		vehicleRegionDao.addVehicleRegion(vehicleRegion);
	}

	@Override
	public void deleteVehicleRegion(String id) {

		vehicleRegionDao.deleteById(id);
	}
}