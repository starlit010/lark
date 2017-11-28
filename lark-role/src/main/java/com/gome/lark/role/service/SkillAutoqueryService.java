package com.gome.lark.role.service;

import com.gome.lark.role.entity.SkillAutoqueryEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SkillAutoqueryService {
	
	SkillAutoqueryEntity queryObject(Integer id);
	
	List<SkillAutoqueryEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SkillAutoqueryEntity skillAutoquery);
	
	void update(SkillAutoqueryEntity skillAutoquery);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
