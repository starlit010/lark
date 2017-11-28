package com.gome.lark.role.service;

import com.gome.lark.role.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SysRoleService {
	
	SysRoleEntity queryObject(Integer roleId);
	
	void delete(Integer roleId);
	
	void deleteBatch(Integer[] roleIds);

	SysRoleEntity queryObject(Long roleId);

	List<SysRoleEntity> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);

	void save(SysRoleEntity role);

	void update(SysRoleEntity role);

	void deleteBatch(Long[] roleIds);
}
