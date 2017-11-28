package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.WhiteListDao;
import com.gome.lark.role.entity.WhiteListEntity;
import com.gome.lark.role.service.WhiteListService;



@Service("whiteListService")
public class WhiteListServiceImpl implements WhiteListService {
	@Autowired
	private WhiteListDao whiteListDao;
	
	@Override
	public WhiteListEntity queryObject(Integer id){
		return whiteListDao.queryObject(id);
	}
	
	@Override
	public List<WhiteListEntity> queryList(Map<String, Object> map){
		return whiteListDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return whiteListDao.queryTotal(map);
	}
	
	@Override
	public void save(WhiteListEntity whiteList){
		whiteListDao.save(whiteList);
	}
	
	@Override
	public void update(WhiteListEntity whiteList){
		whiteListDao.update(whiteList);
	}
	
	@Override
	public void delete(Integer id){
		whiteListDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		whiteListDao.deleteBatch(ids);
	}
	
}
