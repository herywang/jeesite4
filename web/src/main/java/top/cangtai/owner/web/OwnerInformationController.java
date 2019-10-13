/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.owner.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import top.cangtai.owner.entity.OwnerInformation;
import top.cangtai.owner.service.OwnerInformationService;

/**
 * 所有车辆Controller
 * @author majunlong
 * @version 2019-04-18
 */
@Controller
@RequestMapping(value = "${adminPath}/owner/ownerInformation")
public class OwnerInformationController extends BaseController {

	@Autowired
	private OwnerInformationService ownerInformationService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public OwnerInformation get(String id, boolean isNewRecord) {
		return ownerInformationService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("owner:ownerInformation:view")
	@RequestMapping(value = {"list", ""})
	public String list(OwnerInformation ownerInformation, Model model) {
		model.addAttribute("ownerInformation", ownerInformation);
		return "cangtai/owner/ownerInformationList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("owner:ownerInformation:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<OwnerInformation> listData(OwnerInformation ownerInformation, HttpServletRequest request, HttpServletResponse response) {
		ownerInformation.setPage(new Page<>(request, response));
		return  ownerInformationService.findPage(ownerInformation);
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("owner:ownerInformation:view")
	@RequestMapping(value = "form")
	public String form(OwnerInformation ownerInformation, Model model) {
		model.addAttribute("ownerInformation", ownerInformation);
		return "cangtai/owner/ownerInformationForm";
	}

	/**
	 * 保存车辆信息
	 */
	@RequiresPermissions("owner:ownerInformation:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated OwnerInformation ownerInformation) {
		ownerInformationService.save(ownerInformation);
		return renderResult(Global.TRUE, text("保存车辆信息成功！"));
	}
	
	/**
	 * 删除车辆信息
	 */
	@RequiresPermissions("owner:ownerInformation:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(OwnerInformation ownerInformation) {
		ownerInformationService.delete(ownerInformation);
		return renderResult(Global.TRUE, text("删除车辆信息成功！"));
	}
	
}