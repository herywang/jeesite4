/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.setting.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.web.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import top.cangtai.setting.entity.VehicleRegion;
import top.cangtai.setting.service.VehicleRegionServiceImp;

/**
 * 区域设置Controller
 * @author majunlong
 * @version 2019-04-18
 */
@Controller
@RequestMapping(value = "${adminPath}/setting/vehicleRegion")
public class VehicleRegionController  extends BaseController {

	@Autowired
	private VehicleRegionServiceImp vehicleRegionServiceImp;
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("setting:vehicleRegion:view")
	@RequestMapping(value = {"list", ""})
	public String list(VehicleRegion vehicleRegion, Model model) {
		if (vehicleRegion.getLatitude()!=null&&vehicleRegion.getLongitude()!=null&&vehicleRegion.getRadius()!=null){
			vehicleRegion.changeKilometre(vehicleRegion.getRadius());
			vehicleRegionServiceImp.addVehicleRegion(vehicleRegion);
		}else {
			vehicleRegion = vehicleRegionServiceImp.findOneByVehicleRegion();
		}
		model.addAttribute("longitude",vehicleRegion.getLongitude());
		model.addAttribute("latitude",vehicleRegion.getLatitude());
		model.addAttribute("radius",vehicleRegion.obtainKilometre());
		model.addAttribute("vehicleRegion", vehicleRegion);
		return "cangtai/setting/vehicleRegionList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("setting:vehicleRegion:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<VehicleRegion> listData(VehicleRegion vehicleRegion, HttpServletRequest request, HttpServletResponse response) {
		vehicleRegion.setPage(new Page<>(request, response));
		Page<VehicleRegion> page = vehicleRegionServiceImp.findPage(vehicleRegion);
		return page;
	}

	
	/**
	 * 删除区域设置
	 */
	@RequiresPermissions("setting:vehicleRegion:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(VehicleRegion vehicleRegion){
		String id = vehicleRegion.getId();
		vehicleRegionServiceImp.deleteVehicleRegion(id);
		return renderResult(Global.TRUE, text("区域设置删除成功！"));
	}
	
}