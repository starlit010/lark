package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SysRoleDao;
import com.gome.lark.role.entity.SysRoleEntity;
import com.gome.lark.role.service.SysRoleService;



@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Override
	public SysRoleEntity queryObject(Integer roleId){
		return sysRoleDao.queryObject(roleId);
	}
	
	@Override
	public List<SysRoleEntity> queryList(Map<String, Object> map){
		return sysRoleDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysRoleDao.queryTotal(map);
	}
	
	@Override
	public void save(SysRoleEntity sysRole){
		sysRoleDao.save(sysRole);
	}
	
	@Override
	public void update(SysRoleEntity sysRole){
		sysRoleDao.update(sysRole);
	}

	@Override
	public void deleteBatch(Long[] roleIds) {

	}

	@Override
	public void delete(Integer roleId){
		sysRoleDao.delete(roleId);
	}
	
	@Override
	public void deleteBatch(Integer[] roleIds){
		sysRoleDao.deleteBatch(roleIds);
	}

	@Override
	public SysRoleEntity queryObject(Long roleId) {
		return null;
	}

}
