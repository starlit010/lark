package com.gome.lark.role.service.impl;

import com.gome.lark.common.utils.Constant;
import com.gome.lark.role.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SysMenuDao;
import com.gome.lark.role.entity.SysMenuEntity;
import com.gome.lark.role.service.SysMenuService;
import org.springframework.transaction.annotation.Transactional;


@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysUserService sysUserService;

	@Override
	public void delete(Integer menuId){
		sysMenuDao.delete(menuId);
	}
	
	@Override
	public List<SysMenuEntity> queryListParentId(Integer parentId, List<Integer> menuIdList) {
		List<SysMenuEntity> menuList = queryListParentId(parentId);
		if(menuIdList == null){
			return menuList;
		}

		List<SysMenuEntity> userMenuList = new ArrayList<>();
		for(SysMenuEntity menu : menuList){
			if(menuIdList.contains(menu.getMenuId())){
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}

	@Override
	public List<SysMenuEntity> queryListParentId(Integer parentId) {
		return sysMenuDao.queryListParentId(parentId);
	}

	@Override
	public List<SysMenuEntity> queryNotButtonList() {
		return sysMenuDao.queryNotButtonList();
	}

	@Override
	public List<SysMenuEntity> getUserMenuList(Integer userId) {
		//系统管理员，拥有最高权限
		if(userId == Constant.SUPER_ADMIN){
			return getAllMenuList(null);
		}

		//用户菜单列表
		List<Integer> menuIdList = sysUserService.queryAllMenuId(userId);
		return getAllMenuList(menuIdList);
	}

	@Override
	public SysMenuEntity queryObject(Integer menuId) {
		return sysMenuDao.queryObject(menuId);
	}

	@Override
	public List<SysMenuEntity> queryList(Map<String, Object> map) {
		return sysMenuDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysMenuDao.queryTotal(map);
	}

	@Override
	public void save(SysMenuEntity menu) {
		sysMenuDao.save(menu);
	}

	@Override
	public void update(SysMenuEntity menu) {
		sysMenuDao.update(menu);
	}

	@Override
	@Transactional
	public void deleteBatch(Integer[] menuIds) {
		sysMenuDao.deleteBatch(menuIds);
	}

	@Override
	public List<SysMenuEntity> queryUserList(Integer userId) {
		return sysMenuDao.queryUserList(userId);
	}

	/**
	 * 获取所有菜单列表
	 */
	private List<SysMenuEntity> getAllMenuList(List<Integer> menuIdList){
		//查询根菜单列表
		List<SysMenuEntity> menuList = queryListParentId(0, menuIdList);
		//递归获取子菜单
		getMenuTreeList(menuList, menuIdList);

		return menuList;
	}

	/**
	 * 递归
	 */
	private List<SysMenuEntity> getMenuTreeList(List<SysMenuEntity> menuList, List<Integer> menuIdList){
		List<SysMenuEntity> subMenuList = new ArrayList<SysMenuEntity>();

		for(SysMenuEntity entity : menuList){
			if(entity.getType() == Constant.MenuType.CATALOG.getValue()){//目录
				entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
			}
			subMenuList.add(entity);
		}

		return subMenuList;
	}

}
