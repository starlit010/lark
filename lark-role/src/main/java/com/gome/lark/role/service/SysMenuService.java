package com.gome.lark.role.service;

import com.gome.lark.role.entity.SysMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SysMenuService {
	
	void delete(Integer menuId);
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 * @param menuIdList  用户菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Integer parentId, List<Integer> menuIdList);

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Integer parentId);

	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenuEntity> queryNotButtonList();

	/**
	 * 获取用户菜单列表
	 */
	List<SysMenuEntity> getUserMenuList(Integer userId);

	/**
	 * 查询菜单
	 */
	SysMenuEntity queryObject(Integer menuId);

	/**
	 * 查询菜单列表
	 */
	List<SysMenuEntity> queryList(Map<String, Object> map);

	/**
	 * 查询总数
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 保存菜单
	 */
	void save(SysMenuEntity menu);

	/**
	 * 修改
	 */
	void update(SysMenuEntity menu);

	/**
	 * 删除
	 */
	void deleteBatch(Integer[] menuIds);

	/**
	 * 查询用户的权限列表
	 */
	List<SysMenuEntity> queryUserList(Integer userId);
}
