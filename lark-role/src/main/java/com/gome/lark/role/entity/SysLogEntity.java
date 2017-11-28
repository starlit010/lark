package com.gome.lark.role.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 系统日志
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public class SysLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String userId;
	//
	private Integer channelId;
	//
	private Date createTime;
	//
	private Date updateTime;

	private Long id;
	//用户名
	private String username;
	//用户操作
	private String operation;
	//请求方法
	private String method;
	//请求参数
	private String params;
	//执行时长(毫秒)
	private Long time;
	//IP地址
	private String ip;
	//创建时间
	private Date createDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	/**
	 * 获取：
	 */
	public String getOperation() {
		return operation;
	}
	/**
	 * 设置：
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * 获取：
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * 设置：
	 */
	public void setParams(String params) {
		this.params = params;
	}
	/**
	 * 获取：
	 */
	public String getParams() {
		return params;
	}
	/**
	 * 设置：
	 */
	public void setTime(Long time) {
		this.time = time;
	}
	/**
	 * 获取：
	 */
	public Long getTime() {
		return time;
	}
	/**
	 * 设置：
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 获取：
	 */
	public String getIp() {
		return ip;
	}
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
