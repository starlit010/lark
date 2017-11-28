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
public class PageMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer menuId;
	//
	private String menuName;
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
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	/**
	 * 获取：
	 */
	public Integer getMenuId() {
		return menuId;
	}
	/**
	 * 设置：
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * 获取：
	 */
	public String getMenuName() {
		return menuName;
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
