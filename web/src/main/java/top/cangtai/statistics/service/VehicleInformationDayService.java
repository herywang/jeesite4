/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.statistics.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.service.CrudService;
import top.cangtai.statistics.entity.QueryCriteria;
import top.cangtai.statistics.entity.Statistics;
import top.cangtai.statistics.entity.VehicleInformationDay;
import top.cangtai.statistics.dao.VehicleInformationDayDao;
import java.util.LinkedList;
import java.util.List;

/**
 * 自定义统计Service
 * @author majunlong
 * @version 2019-04-19
 */
@Service
public class VehicleInformationDayService extends CrudService<VehicleInformationDayDao, VehicleInformationDay> {

    @Autowired
    private VehicleInformationDayDao vehicleInformation;

    public Statistics findAllVehicleInformationByDay(QueryCriteria queryCriteria){
        List<VehicleInformationDay> information = vehicleInformation.findAllVehicleInformationByDay(queryCriteria);
        return findAllVehicleInformation(information);
    }

    public Statistics findAllVehicleInformationByMonth(QueryCriteria queryCriteria){
        List<VehicleInformationDay> information = vehicleInformation.findAllVehicleInformationByMonth(queryCriteria);
        return findAllVehicleInformation(information);
    }

    public Statistics findAllVehicleInformationByYear(QueryCriteria queryCriteria){
        List<VehicleInformationDay> information = vehicleInformation.findAllVehicleInformationByYear(queryCriteria);
        return findAllVehicleInformation(information);
    }

    public Statistics findAllVehicleInformationByWeek(QueryCriteria queryCriteria){
        List<VehicleInformationDay> information = vehicleInformation.findAllVehicleInformationByWeek(queryCriteria);
        return findAllVehicleInformation(information);
    }

    private Statistics findAllVehicleInformation(List<VehicleInformationDay> vehicleInformations){
        List<Double> numCarss = new LinkedList<>();
        List<Double> vehicleSpeeds = new LinkedList<>();
        List<Double> carbonDioxides = new LinkedList<>();
        List<Double> oils = new LinkedList<>();
        List<String> times = new LinkedList<>();

        for (VehicleInformationDay information : vehicleInformations) {
            numCarss.add(information.getNumCars());
            vehicleSpeeds.add(information.getVehicleSpeed());
            carbonDioxides.add(information.getCarbonDioxide());
            oils.add(information.getOil());
            times.add("'"+information.getDateStr()+"'");
        }
        Statistics statistics = new Statistics();
        statistics.setTimes(times);
        statistics.setCarbonDioxides(carbonDioxides);
        statistics.setNumCarss(numCarss);
        statistics.setOils(oils);
        statistics.setVehicleSpeeds(vehicleSpeeds);
        return statistics;
    }
	
}