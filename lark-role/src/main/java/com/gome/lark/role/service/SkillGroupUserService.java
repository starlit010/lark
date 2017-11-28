package com.gome.lark.role.service;

import com.gome.lark.role.entity.SkillGroupUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SkillGroupUserService {
	
	SkillGroupUserEntity queryObject(Integer id);
	
	List<SkillGroupUserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SkillGroupUserEntity skillGroupUser);
	
	void update(SkillGroupUserEntity skillGroupUser);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
