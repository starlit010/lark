package com.gome.lark.role.service;

import com.gome.lark.role.entity.SysChannelEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:44
 */
public interface SysChannelService {
	
	SysChannelEntity queryObject(Integer channelId);
	
	List<SysChannelEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysChannelEntity channel);
	
	void update(SysChannelEntity channel);
	
	void delete(Integer channelId);
	
	void deleteBatch(Integer[] channelIds);
}
