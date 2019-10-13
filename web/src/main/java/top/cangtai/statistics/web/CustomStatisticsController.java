/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.statistics.web;

import com.jeesite.common.web.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.cangtai.statistics.entity.QueryCriteria;
import top.cangtai.statistics.entity.Statistics;
import top.cangtai.statistics.service.VehicleInformationDayService;
import top.cangtai.statistics.service.VehicleInformationHourService;

/**
 * 自定义统计Controller
 * @author majunlong
 * @version 2019-04-19
 */
@Controller
@RequestMapping(value = "${adminPath}/statistics/customStatisticsController")
public class CustomStatisticsController extends BaseController {

	@Autowired
	private VehicleInformationDayService vehicleInformationDayService;

	@Autowired
	private VehicleInformationHourService vehicleInformationHourService;
	
	@RequiresPermissions("statistics:customStatistics:view")
	@RequestMapping(value = {"list", ""})
	public String list(QueryCriteria queryCriteria, Model model) {

		model.addAttribute("queryCriteria",queryCriteria);
		Integer type = queryCriteria.getType();
		Statistics statistics;
		if (type==null){
			statistics= vehicleInformationHourService.findAllVehicleInformation(queryCriteria);
		}else {
			switch (type){
				case 1:
					statistics = vehicleInformationDayService.findAllVehicleInformationByYear(queryCriteria);
					break;
				case 2:
					statistics = vehicleInformationDayService.findAllVehicleInformationByMonth(queryCriteria);
					break;
				case 3:
					statistics = vehicleInformationDayService.findAllVehicleInformationByWeek(queryCriteria);
					break;
				case 4:
					statistics = vehicleInformationDayService.findAllVehicleInformationByDay(queryCriteria);
					break;
				default:
					statistics= vehicleInformationHourService.findAllVehicleInformation(queryCriteria);
					break;
			}
		}

		model.addAttribute("statistics",statistics);
		return "cangtai/statistics/customStatistics";
	}

	
}