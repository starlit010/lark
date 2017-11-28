package com.gome.lark.role.service;

import com.gome.lark.role.entity.UserTokenEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface UserTokenService {
	
	UserTokenEntity queryObject(Integer userId);
	
	List<UserTokenEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserTokenEntity userToken);
	
	void update(UserTokenEntity userToken);
	
	void delete(Integer userId);
	
	void deleteBatch(Integer[] userIds);
}
