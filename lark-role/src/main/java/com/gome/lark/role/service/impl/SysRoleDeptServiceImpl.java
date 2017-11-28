package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SysRoleDeptDao;
import com.gome.lark.role.entity.SysRoleDeptEntity;
import com.gome.lark.role.service.SysRoleDeptService;



@Service("sysRoleDeptService")
public class SysRoleDeptServiceImpl implements SysRoleDeptService {
	@Autowired
	private SysRoleDeptDao sysRoleDeptDao;
	
	@Override
	public SysRoleDeptEntity queryObject(Integer id){
		return sysRoleDeptDao.queryObject(id);
	}
	
	@Override
	public List<SysRoleDeptEntity> queryList(Map<String, Object> map){
		return sysRoleDeptDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysRoleDeptDao.queryTotal(map);
	}
	
	@Override
	public void save(SysRoleDeptEntity sysRoleDept){
		sysRoleDeptDao.save(sysRoleDept);
	}
	
	@Override
	public void update(SysRoleDeptEntity sysRoleDept){
		sysRoleDeptDao.update(sysRoleDept);
	}
	
	@Override
	public void delete(Integer id){
		sysRoleDeptDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysRoleDeptDao.deleteBatch(ids);
	}

	@Override
	public void saveOrUpdate(Long roleId, List<Long> deptIdList) {

	}

	@Override
	public List<Long> queryDeptIdList(Long roleId) {
		return null;
	}

}
