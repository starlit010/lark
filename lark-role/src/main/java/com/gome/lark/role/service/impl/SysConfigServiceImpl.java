package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SysConfigDao;
import com.gome.lark.role.entity.SysConfigEntity;
import com.gome.lark.role.service.SysConfigService;



@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService {
	@Autowired
	private SysConfigDao sysConfigDao;
	
	@Override
	public SysConfigEntity queryObject(Integer id){
		return sysConfigDao.queryObject(id);
	}
	
	@Override
	public List<SysConfigEntity> queryList(Map<String, Object> map){
		return sysConfigDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysConfigDao.queryTotal(map);
	}

	@Override
	public SysConfigEntity queryObject(Long id) {
		return null;
	}

	@Override
	public String getValue(String key) {
		return null;
	}

	@Override
	public <T> T getConfigObject(String key, Class<T> clazz) {
		return null;
	}

	@Override
	public void save(SysConfigEntity sysConfig){
		sysConfigDao.save(sysConfig);
	}
	
	@Override
	public void update(SysConfigEntity sysConfig){
		sysConfigDao.update(sysConfig);
	}

	@Override
	public void updateValueByKey(String key, String value) {

	}

	@Override
	public void deleteBatch(Long[] ids) {

	}

	@Override
	public void delete(Integer id){
		sysConfigDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysConfigDao.deleteBatch(ids);
	}
	
}
