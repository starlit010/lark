package com.gome.lark.role.service;

import com.gome.lark.role.entity.AppEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:44
 */
public interface AppService {
	
	AppEntity queryObject(Integer appId);
	
	List<AppEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AppEntity app);
	
	void update(AppEntity app);
	
	void delete(Integer appId);
	
	void deleteBatch(Integer[] appIds);
}
