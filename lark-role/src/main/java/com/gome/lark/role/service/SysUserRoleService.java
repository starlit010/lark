package com.gome.lark.role.service;

import com.gome.lark.role.entity.SysUserRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SysUserRoleService {
	
	SysUserRoleEntity queryObject(Integer id);
	
	List<SysUserRoleEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysUserRoleEntity sysUserRole);
	
	void update(SysUserRoleEntity sysUserRole);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void saveOrUpdate(Long userId, List<Long> roleIdList);

	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);

	void delete(Long userId);
}
