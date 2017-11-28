package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SysLogDao;
import com.gome.lark.role.entity.SysLogEntity;
import com.gome.lark.role.service.SysLogService;



@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public SysLogEntity queryObject(Integer id){
		return sysLogDao.queryObject(id);
	}
	
	@Override
	public List<SysLogEntity> queryList(Map<String, Object> map){
		return sysLogDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysLogDao.queryTotal(map);
	}
	
	@Override
	public void save(SysLogEntity sysLog){
		sysLogDao.save(sysLog);
	}
	
	@Override
	public void update(SysLogEntity sysLog){
		sysLogDao.update(sysLog);
	}
	
	@Override
	public void delete(Integer id){
		sysLogDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysLogDao.deleteBatch(ids);
	}
	
}
