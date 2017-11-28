package com.gome.lark.role.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:44
 */
public class BusinessUserExtEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String shopNo;
	//
	private Integer userId;
	//
	private String shopName;
	//
	private String dialogName;
	//
	private Integer startStatus;
	//
	private Integer cfgCount;
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
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}
	/**
	 * 获取：
	 */
	public String getShopNo() {
		return shopNo;
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
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * 获取：
	 */
	public String getShopName() {
		return shopName;
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
	public void setStartStatus(Integer startStatus) {
		this.startStatus = startStatus;
	}
	/**
	 * 获取：
	 */
	public Integer getStartStatus() {
		return startStatus;
	}
	/**
	 * 设置：
	 */
	public void setCfgCount(Integer cfgCount) {
		this.cfgCount = cfgCount;
	}
	/**
	 * 获取：
	 */
	public Integer getCfgCount() {
		return cfgCount;
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
