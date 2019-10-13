package top.cangtai.realtime.entity;

import com.jeesite.common.entity.Page;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;
import top.cangtai.PageAndQuery;


/**
 * 车辆信息Entity
 * @author majunlong
 * @version 2019-04-16
 */
@Document(collection = "real_time_vehicle_information")
public class RealTimeVehicleInformation implements PageAndQuery {

	private String idCard;		// 身份证

	private Double[] position;

	private String moduleNumber;		// 模块编号

	private Integer engineSpeed;		// 发动机转速

	private Double longitude;		// 经度

	private Double latitude;		// 纬度

	private Double mailbox;		// 油箱百分比

	private String name;		// 用户名

	private Date datetime;		// 上传时间

	private Double carbonDioxide;		// 二氧化碳

	private Page<?> page;


	@Override
	public Query getQuery(String orderBy){
		return VehicleQueryUtil.getOuery(orderBy, this);
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getModuleNumber() {
		return moduleNumber;
	}

	public void setModuleNumber(String moduleNumber) {
		this.moduleNumber = moduleNumber;
	}

	public Integer getEngineSpeed() {
		return engineSpeed;
	}

	public void setEngineSpeed(Integer engineSpeed) {
		this.engineSpeed = engineSpeed;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}




	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getMailbox() {
		return mailbox;
	}

	public void setMailbox(Double mailbox) {
		this.mailbox = mailbox;
	}

	public Double getCarbonDioxide() {
		return carbonDioxide;
	}

	public void setCarbonDioxide(Double carbonDioxide) {
		this.carbonDioxide = carbonDioxide;
	}

	public Double[] getPosition() {
		return position;
	}

	public void setPosition(Double[] position) {
		this.position = position;
	}

	@Override
	public Page<?> getPage() {
		return page;
	}

	@Override
	public void setPage(Page<?> page) {
		this.page = page;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}