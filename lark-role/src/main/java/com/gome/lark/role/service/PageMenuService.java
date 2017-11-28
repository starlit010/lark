package com.gome.lark.role.service;

import com.gome.lark.role.entity.PageMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface PageMenuService {
	
	PageMenuEntity queryObject(Integer menuId);
	
	List<PageMenuEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PageMenuEntity pageMenu);
	
	void update(PageMenuEntity pageMenu);
	
	void delete(Integer menuId);
	
	void deleteBatch(Integer[] menuIds);
}
