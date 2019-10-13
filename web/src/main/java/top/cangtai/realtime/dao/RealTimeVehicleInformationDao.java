/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.realtime.dao;


import org.springframework.data.mongodb.core.query.Query;
import top.cangtai.PageAndQuery;

import java.util.List;

/**
 * 车辆信息DAO接口
 * @author majunlong
 * @version 2019-04-16
 */
public interface RealTimeVehicleInformationDao{


    <T extends PageAndQuery> List<T> findDataByQuery(Query query, Integer pageNo, T t);


    <T extends PageAndQuery> long findCount(Query query, T t);

}