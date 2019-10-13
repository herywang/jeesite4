/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package top.cangtai.owner.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 所有车辆Entity
 * @author majunlong
 * @version 2019-04-18
 */
@Table(name="owner_information", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="module_number", attrName="moduleNumber", label="模块编号", queryType=QueryType.LIKE),
		@Column(name="id_card", attrName="idCard", label="身份证号码", queryType=QueryType.LIKE),
		@Column(name="user_name", attrName="userName", label="用户名", queryType=QueryType.LIKE),
		@Column(name="sex", attrName="sex", label="性别"),
		@Column(name="age", attrName="age", label="年龄"),
		@Column(name="birthday", attrName="birthday", label="生日"),
		@Column(name="email", attrName="email", label="电子邮箱", queryType=QueryType.LIKE),
		@Column(name="phone_number", attrName="phoneNumber", label="手机号", queryType=QueryType.LIKE),
		@Column(name="license_plate", attrName="licensePlate", label="车牌", queryType=QueryType.LIKE),
		@Column(name="password", attrName="password", label="密码"),
	}, orderBy="a.id DESC"
)
public class OwnerInformation extends DataEntity<OwnerInformation> {
	
	private static final long serialVersionUID = 1L;
	private String moduleNumber;		// 模块编号
	private String idCard;		// 身份证号码
	private String userName;		// 用户名
	private String sex;		// 性别
	private Long age;		// 年龄
	private Date birthday;		// 生日
	private String email;		// 电子邮箱
	private String phoneNumber;		// 手机号
	private String licensePlate;		// 车牌
	private String password;		// 密码
	
	public OwnerInformation() {
		this(null);
	}

	public OwnerInformation(String id){
		super(id);
	}
	
	@NotBlank(message="模块编号不能为空")
	@Length(min=0, max=20, message="模块编号长度不能超过 20 个字符")
	public String getModuleNumber() {
		return moduleNumber;
	}

	public void setModuleNumber(String moduleNumber) {
		this.moduleNumber = moduleNumber;
	}
	
	@NotBlank(message="身份证号码不能为空")
	@Length(min=0, max=100, message="身份证号码长度不能超过 100 个字符")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@Length(min=0, max=100, message="用户名长度不能超过 100 个字符")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Length(min=0, max=100, message="电子邮箱长度不能超过 100 个字符")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotBlank(message="手机号不能为空")
	@Length(min=0, max=20, message="手机号长度不能超过 20 个字符")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@NotBlank(message="车牌不能为空")
	@Length(min=0, max=100, message="车牌长度不能超过 100 个字符")
	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	@Length(min=0, max=100, message="密码长度不能超过 100 个字符")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}