package com.gome.lark.role.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 使用客服服务端回答访客问题的人
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer userId;
	//
	private String username;
	//
	private String password;
	//
	private String salt;
	//
	private String email;
	//
	private String mobile;
	//
	private Integer status;
	//
	private Integer deptId;
	//
	private Integer channelId;
	//
	private Integer serviceLimit;
	//
	private Integer defaultState;
	//
	private String nickname;
	//
	private String usericon;
	//
	private String employeeid;
	//1:自营 2:商家 3;供应商
	private Integer usertype;
	//
	private Date createTime;
	//
	private Date updateTime;
	//
	private String remark;
	//
	private Integer delFlag;

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
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * 获取：
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * 设置：
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：
	 */
	public Integer getDeptId() {
		return deptId;
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
	public void setServiceLimit(Integer serviceLimit) {
		this.serviceLimit = serviceLimit;
	}
	/**
	 * 获取：
	 */
	public Integer getServiceLimit() {
		return serviceLimit;
	}
	/**
	 * 设置：
	 */
	public void setDefaultState(Integer defaultState) {
		this.defaultState = defaultState;
	}
	/**
	 * 获取：
	 */
	public Integer getDefaultState() {
		return defaultState;
	}
	/**
	 * 设置：
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：
	 */
	public void setUsericon(String usericon) {
		this.usericon = usericon;
	}
	/**
	 * 获取：
	 */
	public String getUsericon() {
		return usericon;
	}
	/**
	 * 设置：
	 */
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	/**
	 * 获取：
	 */
	public String getEmployeeid() {
		return employeeid;
	}
	/**
	 * 设置：1:自营 2:商家 3;供应商
	 */
	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}
	/**
	 * 获取：1:自营 2:商家 3;供应商
	 */
	public Integer getUsertype() {
		return usertype;
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
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
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
