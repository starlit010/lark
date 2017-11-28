package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.UserTokenDao;
import com.gome.lark.role.entity.UserTokenEntity;
import com.gome.lark.role.service.UserTokenService;



@Service("userTokenService")
public class UserTokenServiceImpl implements UserTokenService {
	@Autowired
	private UserTokenDao userTokenDao;
	
	@Override
	public UserTokenEntity queryObject(Integer userId){
		return userTokenDao.queryObject(userId);
	}
	
	@Override
	public List<UserTokenEntity> queryList(Map<String, Object> map){
		return userTokenDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userTokenDao.queryTotal(map);
	}
	
	@Override
	public void save(UserTokenEntity userToken){
		userTokenDao.save(userToken);
	}
	
	@Override
	public void update(UserTokenEntity userToken){
		userTokenDao.update(userToken);
	}
	
	@Override
	public void delete(Integer userId){
		userTokenDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Integer[] userIds){
		userTokenDao.deleteBatch(userIds);
	}
	
}
