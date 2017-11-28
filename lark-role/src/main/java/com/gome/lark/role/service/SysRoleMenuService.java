package com.gome.lark.role.service;

import com.gome.lark.role.entity.SysRoleMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色与菜单对应关系
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SysRoleMenuService {
	
	SysRoleMenuEntity queryObject(Integer id);
	
	List<SysRoleMenuEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysRoleMenuEntity sysRoleMenu);
	
	void update(SysRoleMenuEntity sysRoleMenu);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void saveOrUpdate(Long roleId, List<Long> menuIdList);

	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);
}
