package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SkillAutoqueryDao;
import com.gome.lark.role.entity.SkillAutoqueryEntity;
import com.gome.lark.role.service.SkillAutoqueryService;



@Service("skillAutoqueryService")
public class SkillAutoqueryServiceImpl implements SkillAutoqueryService {
	@Autowired
	private SkillAutoqueryDao skillAutoqueryDao;
	
	@Override
	public SkillAutoqueryEntity queryObject(Integer id){
		return skillAutoqueryDao.queryObject(id);
	}
	
	@Override
	public List<SkillAutoqueryEntity> queryList(Map<String, Object> map){
		return skillAutoqueryDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return skillAutoqueryDao.queryTotal(map);
	}
	
	@Override
	public void save(SkillAutoqueryEntity skillAutoquery){
		skillAutoqueryDao.save(skillAutoquery);
	}
	
	@Override
	public void update(SkillAutoqueryEntity skillAutoquery){
		skillAutoqueryDao.update(skillAutoquery);
	}
	
	@Override
	public void delete(Integer id){
		skillAutoqueryDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		skillAutoqueryDao.deleteBatch(ids);
	}
	
}
