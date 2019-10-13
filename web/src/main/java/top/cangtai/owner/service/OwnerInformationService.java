/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.owner.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import top.cangtai.owner.entity.OwnerInformation;
import top.cangtai.owner.dao.OwnerInformationDao;

/**
 * 所有车辆Service
 * @author majunlong
 * @version 2019-04-18
 */
@Service
@Transactional(readOnly=true)
public class OwnerInformationService extends CrudService<OwnerInformationDao, OwnerInformation> {
	
	/**
	 * 获取单条数据
	 * @param ownerInformation
	 * @return
	 */
	@Override
	public OwnerInformation get(OwnerInformation ownerInformation) {
		return super.get(ownerInformation);
	}
	
	/**
	 * 查询分页数据
	 * @param ownerInformation 查询条件
	 * @param ownerInformation.page 分页对象
	 * @return
	 */
	@Override
	public Page<OwnerInformation> findPage(OwnerInformation ownerInformation) {
		return super.findPage(ownerInformation);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param ownerInformation
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(OwnerInformation ownerInformation) {
		super.save(ownerInformation);
	}
	
	/**
	 * 更新状态
	 * @param ownerInformation
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(OwnerInformation ownerInformation) {
		super.updateStatus(ownerInformation);
	}
	
	/**
	 * 删除数据
	 * @param ownerInformation
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(OwnerInformation ownerInformation) {
		super.delete(ownerInformation);
	}
	
}