package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.AppDao;
import com.gome.lark.role.entity.AppEntity;
import com.gome.lark.role.service.AppService;



@Service("appService")
public class AppServiceImpl implements AppService {
	@Autowired
	private AppDao appDao;
	
	@Override
	public AppEntity queryObject(Integer appId){
		return appDao.queryObject(appId);
	}
	
	@Override
	public List<AppEntity> queryList(Map<String, Object> map){
		return appDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return appDao.queryTotal(map);
	}
	
	@Override
	public void save(AppEntity app){
		appDao.save(app);
	}
	
	@Override
	public void update(AppEntity app){
		appDao.update(app);
	}
	
	@Override
	public void delete(Integer appId){
		appDao.delete(appId);
	}
	
	@Override
	public void deleteBatch(Integer[] appIds){
		appDao.deleteBatch(appIds);
	}
	
}
