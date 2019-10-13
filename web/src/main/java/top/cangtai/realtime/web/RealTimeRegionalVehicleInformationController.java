/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.realtime.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import top.cangtai.PageAndQuery;
import top.cangtai.realtime.entity.RealTimeRegionalVehicleInformation;
import top.cangtai.realtime.service.RealTimeVehicleInformationService;
import top.cangtai.setting.entity.VehicleRegion;
import top.cangtai.setting.service.VehicleRegionService;

/**
 * 实时车辆信息Controller
 * @author majunlong
 * @version 2019-04-17
 */
@Controller
@RequestMapping(value = "${adminPath}/realtime/realTimeRegionalVehicleInformation")
public class RealTimeRegionalVehicleInformationController extends BaseController {

	@Autowired
	private RealTimeVehicleInformationService realTimeVehicleInformationServiceImp;
	@Autowired
	private VehicleRegionService vehicleRegionService;

	/**
	 * 查询列表
	 */
	@RequiresPermissions("realtime:realTimeRegionalVehicleInformation:view")
	@RequestMapping(value = {"list", ""})
	public String list(RealTimeRegionalVehicleInformation realTimeRegionalVehicleInformation, Model model) {
		model.addAttribute("realTimeRegionalVehicleInformation", realTimeRegionalVehicleInformation);
		Double longitude = realTimeRegionalVehicleInformation.getLongitude();
		Double latitude = realTimeRegionalVehicleInformation.getLatitude();
		if (longitude==null||latitude==null){
			VehicleRegion vehicleRegion = vehicleRegionService.findOneByVehicleRegion();
			longitude=vehicleRegion.getLongitude();
			latitude=vehicleRegion.getLatitude();
		}else {
			vehicleRegionService.addVehicleRegion(longitude,latitude);
		}
		model.addAttribute("longitude",longitude);
		model.addAttribute("latitude",latitude);
		return "cangtai/realtime/realTimeRegionalVehicleInformationList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("realtime:realTimeRegionalVehicleInformation:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<RealTimeRegionalVehicleInformation> listData(RealTimeRegionalVehicleInformation realTimeRegionalVehicleInformation, HttpServletRequest request, HttpServletResponse response) {
		VehicleRegion vehicleRegion = vehicleRegionService.findOneByVehicleRegion();
		realTimeRegionalVehicleInformation.setLongitude(vehicleRegion.getLongitude());
		realTimeRegionalVehicleInformation.setLatitude(vehicleRegion.getLatitude());
		realTimeRegionalVehicleInformation.setRadius(vehicleRegion.getRadius());
		realTimeRegionalVehicleInformation.setPage(new Page<PageAndQuery>(request, response));
		return realTimeVehicleInformationServiceImp.findPage(realTimeRegionalVehicleInformation);
	}
	
}