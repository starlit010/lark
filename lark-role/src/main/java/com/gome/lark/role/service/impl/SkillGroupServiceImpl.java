package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SkillGroupDao;
import com.gome.lark.role.entity.SkillGroupEntity;
import com.gome.lark.role.service.SkillGroupService;



@Service("skillGroupService")
public class SkillGroupServiceImpl implements SkillGroupService {
	@Autowired
	private SkillGroupDao skillGroupDao;
	
	@Override
	public SkillGroupEntity queryObject(Integer skillId){
		return skillGroupDao.queryObject(skillId);
	}
	
	@Override
	public List<SkillGroupEntity> queryList(Map<String, Object> map){
		return skillGroupDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return skillGroupDao.queryTotal(map);
	}
	
	@Override
	public void save(SkillGroupEntity skillGroup){
		skillGroupDao.save(skillGroup);
	}
	
	@Override
	public void update(SkillGroupEntity skillGroup){
		skillGroupDao.update(skillGroup);
	}
	
	@Override
	public void delete(Integer skillId){
		skillGroupDao.delete(skillId);
	}
	
	@Override
	public void deleteBatch(Integer[] skillIds){
		skillGroupDao.deleteBatch(skillIds);
	}
	
}
