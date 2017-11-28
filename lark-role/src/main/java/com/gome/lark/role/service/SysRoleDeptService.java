package com.gome.lark.role.service;

import com.gome.lark.role.entity.SysRoleDeptEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色与部门对应关系
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SysRoleDeptService {
	
	SysRoleDeptEntity queryObject(Integer id);
	
	List<SysRoleDeptEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysRoleDeptEntity sysRoleDept);
	
	void update(SysRoleDeptEntity sysRoleDept);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void saveOrUpdate(Long roleId, List<Long> deptIdList);

	/**
	 * 根据角色ID，获取部门ID列表
	 */
	List<Long> queryDeptIdList(Long roleId);
}
