/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.realtime.service;


import com.jeesite.common.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import top.cangtai.realtime.dao.RealTimeVehicleInformationDao;
import top.cangtai.PageAndQuery;

import java.util.List;

/**
 * 车辆信息Service
 * @author majunlong
 * @version 2019-04-16
 */
@Service
public class RealTimeVehicleInformationServiceImp implements  RealTimeVehicleInformationService{

	@Autowired
	private RealTimeVehicleInformationDao vehicleInformationDao;

	@Override
	public <T extends PageAndQuery> Page<T>  findPage(T pageAndQuery) {
		Page<T> objectPage = (Page<T>) pageAndQuery.getPage();
		Query query = pageAndQuery.getQuery(objectPage.getOrderBy());
		List<T> realTimeVehicleInformationList = vehicleInformationDao.findDataByQuery(query,objectPage.getPageNo(),pageAndQuery);
		long realTimeVehicleInformationCount = vehicleInformationDao.findCount(query,pageAndQuery);
		objectPage.setCount(realTimeVehicleInformationCount);
		objectPage.setList(realTimeVehicleInformationList);

		return objectPage;
	}

}