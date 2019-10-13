/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.statistics.service;


import com.jeesite.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.cangtai.statistics.dao.VehicleInformationHourDao;
import top.cangtai.statistics.entity.QueryCriteria;
import top.cangtai.statistics.entity.Statistics;
import top.cangtai.statistics.entity.VehicleInformationHour;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * 统计Service
 * @author majunlong
 * @version 2019-04-19
 */
@Service
public class VehicleInformationHourService extends CrudService<VehicleInformationHourDao, VehicleInformationHour> {
	@Autowired
    private VehicleInformationHourDao vehicleInformationHourDao;

    public Statistics findAllVehicleInformation(QueryCriteria queryCriteria){
        List<VehicleInformationHour> allVehicleInformations = vehicleInformationHourDao.findAllVehicleInformation(queryCriteria);
        List<Double> numCarss = new LinkedList<>();
        List<Double> vehicleSpeeds = new LinkedList<>();
        List<Double> carbonDioxides = new LinkedList<>();
        List<Double> oils = new LinkedList<>();
        List<String> times = new LinkedList<>();
        for (VehicleInformationHour allVehicleInformation : allVehicleInformations) {
            numCarss.add(allVehicleInformation.getNumCars());
            vehicleSpeeds.add(allVehicleInformation.getVehicleSpeed());
            carbonDioxides.add(allVehicleInformation.getCarbonDioxide());
            oils.add(allVehicleInformation.getOil());
            Date startTime = allVehicleInformation.getStartTime();
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh");
            String dateStr=sdf.format(startTime);
            times.add("'"+dateStr+"'");
        }
        Statistics statistics = new Statistics();
        statistics.setTimes(times);
        statistics.setCarbonDioxides(carbonDioxides);
        statistics.setNumCarss(numCarss);
        statistics.setOils(oils);
        statistics.setVehicleSpeeds(vehicleSpeeds);
        return  statistics;
    }
}