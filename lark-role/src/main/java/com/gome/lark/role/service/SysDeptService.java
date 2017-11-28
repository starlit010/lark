package com.gome.lark.role.service;

import com.gome.lark.role.entity.SysDeptEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SysDeptService {
	
	SysDeptEntity queryObject(Integer deptId);
	
	List<SysDeptEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysDeptEntity sysDept);
	
	void update(SysDeptEntity sysDept);
	
	void delete(Integer deptId);
	
	void deleteBatch(Integer[] deptIds);

	/**
	 * 查询子部门ID列表
	 * @param parentId  上级部门ID
	 */
	List<Integer> queryDetpIdList(Integer parentId);

	/**
	 * 获取子部门ID(包含本部门ID)，用于数据过滤
	 */
	String getSubDeptIdList(Integer deptId);


}
