package com.gome.lark.role.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 部门管理
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:44
 */
public class AppEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer appId;
	//
	private Integer chaChannelId;
	//
	private String channelId;
	//
	private String appName;
	//
	private Date createTime;
	//
	private Date updateTime;
	//
	private Integer delFlag;

	/**
	 * 设置：
	 */
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	/**
	 * 获取：
	 */
	public Integer getAppId() {
		return appId;
	}
	/**
	 * 设置：
	 */
	public void setChaChannelId(Integer chaChannelId) {
		this.chaChannelId = chaChannelId;
	}
	/**
	 * 获取：
	 */
	public Integer getChaChannelId() {
		return chaChannelId;
	}
	/**
	 * 设置：
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	/**
	 * 获取：
	 */
	public String getChannelId() {
		return channelId;
	}
	/**
	 * 设置：
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	/**
	 * 获取：
	 */
	public String getAppName() {
		return appName;
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
	/**
	 * 设置：
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
}
