package com.gome.lark.role.service;

import com.gome.lark.role.entity.DeptAppEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:44
 */
public interface DeptAppService {
	
	DeptAppEntity queryObject(Integer id);
	
	List<DeptAppEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DeptAppEntity deptApp);
	
	void update(DeptAppEntity deptApp);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
