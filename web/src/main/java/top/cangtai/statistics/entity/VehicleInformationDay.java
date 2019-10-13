/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.statistics.entity;

import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 自定义统计Entity
 * @author majunlong
 * @version 2019-04-19
 */
@Table(name="vehicle_information_day", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="dateStr", attrName="time", label="统计时间"),
		@Column(name="longitude", attrName="longitude", label="经度"),
		@Column(name="latitude", attrName="latitude", label="纬度"),
		@Column(name="num_cars", attrName="numCars", label="汽车数量"),
		@Column(name="vehicle_speed", attrName="vehicleSpeed", label="汽车速度"),
		@Column(name="carbon_dioxide", attrName="carbonDioxide", label="二氧化碳"),
		@Column(name="oil", attrName="oil", label="油耗"),
	}, orderBy="a.id DESC"
)
public class VehicleInformationDay extends DataEntity<VehicleInformationDay> {
	
	private static final long serialVersionUID = 1L;
	private Date time;		// 统计时间

	private String dateStr;

	private Double longitude;		// 经度
	private Double latitude;		// 纬度
	private Double numCars;		// 汽车数量
	private Double vehicleSpeed;		// 汽车速度
	private Double carbonDioxide;		// 二氧化碳
	private Double oil;		// 油耗
	
	public VehicleInformationDay() {
		this(null);
	}

	public VehicleInformationDay(String id){
		super(id);
	}
	

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getNumCars() {
		return numCars;
	}

	public void setNumCars(Double numCars) {
		this.numCars = numCars;
	}
	
	public Double getVehicleSpeed() {
		return vehicleSpeed;
	}

	public void setVehicleSpeed(Double vehicleSpeed) {
		this.vehicleSpeed = vehicleSpeed;
	}
	
	public Double getCarbonDioxide() {
		return carbonDioxide;
	}

	public void setCarbonDioxide(Double carbonDioxide) {
		this.carbonDioxide = carbonDioxide;
	}
	
	public Double getOil() {
		return oil;
	}

	public void setOil(Double oil) {
		this.oil = oil;
	}


	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
}