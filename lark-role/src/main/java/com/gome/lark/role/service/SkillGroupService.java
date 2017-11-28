package com.gome.lark.role.service;

import com.gome.lark.role.entity.SkillGroupEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SkillGroupService {
	
	SkillGroupEntity queryObject(Integer skillId);
	
	List<SkillGroupEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SkillGroupEntity skillGroup);
	
	void update(SkillGroupEntity skillGroup);
	
	void delete(Integer skillId);
	
	void deleteBatch(Integer[] skillIds);
}
