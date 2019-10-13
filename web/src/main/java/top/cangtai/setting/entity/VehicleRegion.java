/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.setting.entity;

import java.util.Date;

import com.jeesite.common.entity.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;
import top.cangtai.PageAndQuery;

/**
 * 区域设置Entity
 * @author majunlong
 * @version 2019-04-18
 */
@Document(collection = "vehicle_region")
public class VehicleRegion implements PageAndQuery {

	private static final String ASC = "asc";

	private String id;

	private Double longitude;

	private Double latitude;

	private Double radius;

	private static final Double KILOMETRE_CONVERSION = 0.009;

	private Date date;

	private Page<?> page;

	public VehicleRegion(Double longitude, Double latitude, Double radius) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.radius = radius;
	}

	public VehicleRegion() {
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public Double getRadius() {
		return radius;
	}

	public void changeKilometre(Double kilometre){
		radius = kilometre*KILOMETRE_CONVERSION;
	}

	public Double obtainKilometre(){
		return radius/KILOMETRE_CONVERSION;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public Query getQuery(String orderBy) {
		Query query = new Query();
		if (orderBy!=null){
			Sort sort;
			String[] sortStr = orderBy.split(" ");
			if (sortStr[1].toLowerCase().equals(ASC)){
				sort = new Sort(Sort.Direction.ASC,sortStr[0]);
			}else {
				sort = new Sort(Sort.Direction.DESC,sortStr[0]);
			}
			query.with(sort);
		}
		return query;
	}

	@Override
	public Page<?> getPage() {
		return page;
	}

	@Override
	public void setPage(Page<?> page) {
		this.page = page;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}