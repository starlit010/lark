package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SkillMappingDao;
import com.gome.lark.role.entity.SkillMappingEntity;
import com.gome.lark.role.service.SkillMappingService;



@Service("skillMappingService")
public class SkillMappingServiceImpl implements SkillMappingService {
	@Autowired
	private SkillMappingDao skillMappingDao;
	
	@Override
	public SkillMappingEntity queryObject(Integer id){
		return skillMappingDao.queryObject(id);
	}
	
	@Override
	public List<SkillMappingEntity> queryList(Map<String, Object> map){
		return skillMappingDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return skillMappingDao.queryTotal(map);
	}
	
	@Override
	public void save(SkillMappingEntity skillMapping){
		skillMappingDao.save(skillMapping);
	}
	
	@Override
	public void update(SkillMappingEntity skillMapping){
		skillMappingDao.update(skillMapping);
	}
	
	@Override
	public void delete(Integer id){
		skillMappingDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		skillMappingDao.deleteBatch(ids);
	}
	
}
