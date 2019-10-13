/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.realtime.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.entity.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.cangtai.PageAndQuery;
import top.cangtai.realtime.entity.RealTimeVehicleInformation;
import top.cangtai.realtime.service.RealTimeVehicleInformationService;

/**
 * 车辆信息Controller
 * @author majunlong
 * @version 2019-04-16
 */
@Controller
@RequestMapping(value = "${adminPath}/realtime/realTimeVehicleInformation")
public class RealTimeVehicleInformationController{

	@Autowired
	private RealTimeVehicleInformationService realTimeVehicleInformationServiceImp;
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("realtime:realTimeVehicleInformation:view")
	@RequestMapping(value = {"list"})
	public String list(RealTimeVehicleInformation realTimeVehicleInformation, Model model) {
		model.addAttribute("realTimeVehicleInformation", realTimeVehicleInformation);
		return "cangtai/realtime/realTimeVehicleInformationList";
	}


	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("realtime:realTimeVehicleInformation:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<RealTimeVehicleInformation> listData(RealTimeVehicleInformation realTimeVehicleInformation, HttpServletRequest request, HttpServletResponse response) {

		realTimeVehicleInformation.setPage(new Page<PageAndQuery>(request,response));
		Page<RealTimeVehicleInformation> page = realTimeVehicleInformationServiceImp.findPage(realTimeVehicleInformation);
		return page;
	}
}