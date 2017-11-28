package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.DeptAppDao;
import com.gome.lark.role.entity.DeptAppEntity;
import com.gome.lark.role.service.DeptAppService;



@Service("deptAppService")
public class DeptAppServiceImpl implements DeptAppService {
	@Autowired
	private DeptAppDao deptAppDao;
	
	@Override
	public DeptAppEntity queryObject(Integer id){
		return deptAppDao.queryObject(id);
	}
	
	@Override
	public List<DeptAppEntity> queryList(Map<String, Object> map){
		return deptAppDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return deptAppDao.queryTotal(map);
	}
	
	@Override
	public void save(DeptAppEntity deptApp){
		deptAppDao.save(deptApp);
	}
	
	@Override
	public void update(DeptAppEntity deptApp){
		deptAppDao.update(deptApp);
	}
	
	@Override
	public void delete(Integer id){
		deptAppDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		deptAppDao.deleteBatch(ids);
	}
	
}
