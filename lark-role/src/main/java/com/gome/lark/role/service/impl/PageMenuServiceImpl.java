package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.PageMenuDao;
import com.gome.lark.role.entity.PageMenuEntity;
import com.gome.lark.role.service.PageMenuService;



@Service("pageMenuService")
public class PageMenuServiceImpl implements PageMenuService {
	@Autowired
	private PageMenuDao pageMenuDao;
	
	@Override
	public PageMenuEntity queryObject(Integer menuId){
		return pageMenuDao.queryObject(menuId);
	}
	
	@Override
	public List<PageMenuEntity> queryList(Map<String, Object> map){
		return pageMenuDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return pageMenuDao.queryTotal(map);
	}
	
	@Override
	public void save(PageMenuEntity pageMenu){
		pageMenuDao.save(pageMenu);
	}
	
	@Override
	public void update(PageMenuEntity pageMenu){
		pageMenuDao.update(pageMenu);
	}
	
	@Override
	public void delete(Integer menuId){
		pageMenuDao.delete(menuId);
	}
	
	@Override
	public void deleteBatch(Integer[] menuIds){
		pageMenuDao.deleteBatch(menuIds);
	}
	
}
