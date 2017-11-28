package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SysRoleMenuDao;
import com.gome.lark.role.entity.SysRoleMenuEntity;
import com.gome.lark.role.service.SysRoleMenuService;



@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Override
	public SysRoleMenuEntity queryObject(Integer id){
		return sysRoleMenuDao.queryObject(id);
	}
	
	@Override
	public List<SysRoleMenuEntity> queryList(Map<String, Object> map){
		return sysRoleMenuDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysRoleMenuDao.queryTotal(map);
	}
	
	@Override
	public void save(SysRoleMenuEntity sysRoleMenu){
		sysRoleMenuDao.save(sysRoleMenu);
	}
	
	@Override
	public void update(SysRoleMenuEntity sysRoleMenu){
		sysRoleMenuDao.update(sysRoleMenu);
	}
	
	@Override
	public void delete(Integer id){
		sysRoleMenuDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysRoleMenuDao.deleteBatch(ids);
	}

	@Override
	public void saveOrUpdate(Long roleId, List<Long> menuIdList) {

	}

	@Override
	public List<Long> queryMenuIdList(Long roleId) {
		return null;
	}

}
