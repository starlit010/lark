package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SysChannelDao;
import com.gome.lark.role.entity.SysChannelEntity;
import com.gome.lark.role.service.SysChannelService;



@Service("channelService")
public class SysChannelServiceImpl implements SysChannelService {
	@Autowired
	private SysChannelDao sysChannelDao;
	
	@Override
	public SysChannelEntity queryObject(Integer channelId){
		return sysChannelDao.queryObject(channelId);
	}
	
	@Override
	public List<SysChannelEntity> queryList(Map<String, Object> map){
		return sysChannelDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysChannelDao.queryTotal(map);
	}
	
	@Override
	public void save(SysChannelEntity channel){
		sysChannelDao.save(channel);
	}
	
	@Override
	public void update(SysChannelEntity channel){
		sysChannelDao.update(channel);
	}
	
	@Override
	public void delete(Integer channelId){
		sysChannelDao.delete(channelId);
	}
	
	@Override
	public void deleteBatch(Integer[] channelIds){
		sysChannelDao.deleteBatch(channelIds);
	}
	
}
