package com.gome.lark.role.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public class SupplierUserExtEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String supplierCode;
	//
	private Integer userId;
	//
	private String dialogName;
	//
	private Integer onlineStatus;
	//
	private String firstCat;
	//
	private String secondCat;
	//
	private String threeCat;
	//
	private String brandId;
	//
	private String provinceCode;
	//
	private String cityCode;
	//
	private String areaCode;
	//
	private Date createTime;
	//
	private Date updateTime;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	/**
	 * 获取：
	 */
	public String getSupplierCode() {
		return supplierCode;
	}
	/**
	 * 设置：
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setDialogName(String dialogName) {
		this.dialogName = dialogName;
	}
	/**
	 * 获取：
	 */
	public String getDialogName() {
		return dialogName;
	}
	/**
	 * 设置：
	 */
	public void setOnlineStatus(Integer onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
	/**
	 * 获取：
	 */
	public Integer getOnlineStatus() {
		return onlineStatus;
	}
	/**
	 * 设置：
	 */
	public void setFirstCat(String firstCat) {
		this.firstCat = firstCat;
	}
	/**
	 * 获取：
	 */
	public String getFirstCat() {
		return firstCat;
	}
	/**
	 * 设置：
	 */
	public void setSecondCat(String secondCat) {
		this.secondCat = secondCat;
	}
	/**
	 * 获取：
	 */
	public String getSecondCat() {
		return secondCat;
	}
	/**
	 * 设置：
	 */
	public void setThreeCat(String threeCat) {
		this.threeCat = threeCat;
	}
	/**
	 * 获取：
	 */
	public String getThreeCat() {
		return threeCat;
	}
	/**
	 * 设置：
	 */
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	/**
	 * 获取：
	 */
	public String getBrandId() {
		return brandId;
	}
	/**
	 * 设置：
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	/**
	 * 获取：
	 */
	public String getProvinceCode() {
		return provinceCode;
	}
	/**
	 * 设置：
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	/**
	 * 获取：
	 */
	public String getCityCode() {
		return cityCode;
	}
	/**
	 * 设置：
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 * 获取：
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
