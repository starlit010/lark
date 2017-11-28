package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SysUserDao;
import com.gome.lark.role.entity.SysUserEntity;
import com.gome.lark.role.service.SysUserService;



@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public SysUserEntity queryObject(Integer userId){
		return sysUserDao.queryObject(userId);
	}
	
	@Override
	public List<SysUserEntity> queryList(Map<String, Object> map){
		return sysUserDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysUserDao.queryTotal(map);
	}
	
	@Override
	public void save(SysUserEntity sysUser){
		sysUserDao.save(sysUser);
	}
	
	@Override
	public void update(SysUserEntity sysUser){
		sysUserDao.update(sysUser);
	}

	@Override
	public void delete(Integer userId){
		sysUserDao.delete(userId);
	}

	@Override
	public List<Integer> queryAllMenuId(Integer userId) {
		return null;
	}

	@Override
	public void deleteBatch(Integer[] userIds){
		sysUserDao.deleteBatch(userIds);
	}

	@Override
	public int updatePassword(Integer userId, String password, String newPassword) {
		return 0;
	}

	@Override
	public List<String> queryAllPerms(Integer userId) {
		return sysUserDao.queryAllPerms(userId);
	}

	@Override
	public SysUserEntity queryByUserName(String username) {
		return null;
	}
}
