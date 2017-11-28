package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SysUserRoleDao;
import com.gome.lark.role.entity.SysUserRoleEntity;
import com.gome.lark.role.service.SysUserRoleService;



@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Override
	public SysUserRoleEntity queryObject(Integer id){
		return sysUserRoleDao.queryObject(id);
	}
	
	@Override
	public List<SysUserRoleEntity> queryList(Map<String, Object> map){
		return sysUserRoleDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysUserRoleDao.queryTotal(map);
	}
	
	@Override
	public void save(SysUserRoleEntity sysUserRole){
		sysUserRoleDao.save(sysUserRole);
	}
	
	@Override
	public void update(SysUserRoleEntity sysUserRole){
		sysUserRoleDao.update(sysUserRole);
	}
	
	@Override
	public void delete(Integer id){
		sysUserRoleDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysUserRoleDao.deleteBatch(ids);
	}

	@Override
	public void saveOrUpdate(Long userId, List<Long> roleIdList) {

	}

	@Override
	public List<Long> queryRoleIdList(Long userId) {
		return null;
	}

	@Override
	public void delete(Long userId) {

	}

}
