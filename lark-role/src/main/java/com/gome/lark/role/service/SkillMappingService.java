package com.gome.lark.role.service;

import com.gome.lark.role.entity.SkillMappingEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SkillMappingService {
	
	SkillMappingEntity queryObject(Integer id);
	
	List<SkillMappingEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SkillMappingEntity skillMapping);
	
	void update(SkillMappingEntity skillMapping);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
