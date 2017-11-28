package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SkillGroupUserDao;
import com.gome.lark.role.entity.SkillGroupUserEntity;
import com.gome.lark.role.service.SkillGroupUserService;



@Service("skillGroupUserService")
public class SkillGroupUserServiceImpl implements SkillGroupUserService {
	@Autowired
	private SkillGroupUserDao skillGroupUserDao;
	
	@Override
	public SkillGroupUserEntity queryObject(Integer id){
		return skillGroupUserDao.queryObject(id);
	}
	
	@Override
	public List<SkillGroupUserEntity> queryList(Map<String, Object> map){
		return skillGroupUserDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return skillGroupUserDao.queryTotal(map);
	}
	
	@Override
	public void save(SkillGroupUserEntity skillGroupUser){
		skillGroupUserDao.save(skillGroupUser);
	}
	
	@Override
	public void update(SkillGroupUserEntity skillGroupUser){
		skillGroupUserDao.update(skillGroupUser);
	}
	
	@Override
	public void delete(Integer id){
		skillGroupUserDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		skillGroupUserDao.deleteBatch(ids);
	}
	
}
