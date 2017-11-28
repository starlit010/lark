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
public class SysChannelEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer channelId;
	//
	private Integer companyid;
	//
	private String channelCode;
	//
	private String name;
	//
	private Date createTime;
	//
	private Date updateTime;
	//
	private Integer delFlag;

	/**
	 * 设置：
	 */
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	/**
	 * 获取：
	 */
	public Integer getChannelId() {
		return channelId;
	}
	/**
	 * 设置：
	 */
	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}
	/**
	 * 获取：
	 */
	public Integer getCompanyid() {
		return companyid;
	}
	/**
	 * 设置：
	 */
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	/**
	 * 获取：
	 */
	public String getChannelCode() {
		return channelCode;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
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
