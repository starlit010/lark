package com.gome.lark.role.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 角色
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public class SysRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer roleId;
	//
	private String roleName;
	//
	private String remark;
	//
	private Integer deptId;
	//
	private Integer channelId;
	//
	private Date createTime;
	//
	private Date updateTime;
	//
	private Integer delFlag;

	/**
	 * 设置：
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * 设置：
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * 获取：
	 */
	public String getRoleName() {
		return roleName;
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
