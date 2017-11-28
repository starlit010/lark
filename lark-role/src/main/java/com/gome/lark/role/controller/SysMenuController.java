package com.gome.lark.role.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gome.lark.common.exception.RRException;
import com.gome.lark.common.utils.Constant;
import com.gome.lark.role.annotation.SysLog;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SysMenuEntity;
import com.gome.lark.role.service.SysMenuService;
import com.gome.lark.common.utils.PageUtils;
import com.gome.lark.common.utils.Query;
import com.gome.lark.common.utils.R;

/**
 * 菜单管理
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends AbstractController{

	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 保存
	 */
	@RequiresPermissions("sysmenu:save")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public R save(@RequestBody SysMenuEntity sysMenu){
		sysMenuService.save(sysMenu);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequiresPermissions("sysmenu:update")
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public R update(@RequestBody SysMenuEntity sysMenu){
		sysMenuService.update(sysMenu);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("sysmenu:delete")
	public R delete(@RequestBody Integer[] menuIds){
		sysMenuService.deleteBatch(menuIds);

		return R.ok();
	}

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions("sysmenu:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysMenuEntity> sysMenuList = sysMenuService.queryList(query);
		int total = sysMenuService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysMenuList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping(value = "/info/{menuId}", method = RequestMethod.GET)
	@RequiresPermissions("sysmenu:info")
	public R info(@PathVariable("menuId") Integer menuId){
		SysMenuEntity sysMenu = sysMenuService.queryObject(menuId);
		
		return R.ok().put("sysMenu", sysMenu);
	}

	/**
	 * 导航菜单
	 */
	@RequestMapping("/nav")
	public R nav(){
		List<SysMenuEntity> menuList = sysMenuService.getUserMenuList(getUserId());
		return R.ok().put("menuList", menuList);
	}

	/**
	 * 所有菜单列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:menu:list")
	public List<SysMenuEntity> list(){
		List<SysMenuEntity> menuList = sysMenuService.queryList(new HashMap<String, Object>());

		return menuList;
	}

	/**
	 * 选择菜单(添加、修改菜单)
	 */
	@RequestMapping("/select")
	@RequiresPermissions("sys:menu:select")
	public R select(){
		//查询列表数据
		List<SysMenuEntity> menuList = sysMenuService.queryNotButtonList();

		//添加顶级菜单
		SysMenuEntity root = new SysMenuEntity();
		root.setMenuId(0);
		root.setName("一级菜单");
		root.setParentId(-1);
//		root.setOpen(true);
		menuList.add(root);

		return R.ok().put("menuList", menuList);
	}

	/**
	 * 删除
	 */
	@SysLog("删除菜单")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:menu:delete")
	public R delete(int menuId){
		if(menuId <= 31){
			return R.error("系统菜单，不能删除");
		}

		//判断是否有子菜单或按钮
		List<SysMenuEntity> menuList = sysMenuService.queryListParentId(menuId);
		if(menuList.size() > 0){
			return R.error("请先删除子菜单或按钮");
		}

		sysMenuService.deleteBatch(new Integer[]{menuId});

		return R.ok();
	}

	/**
	 * 验证参数是否正确
	 */
	private void verifyForm(SysMenuEntity menu){
		if(StringUtils.isBlank(menu.getName())){
			throw new RRException("菜单名称不能为空");
		}

		if(menu.getParentId() == null){
			throw new RRException("上级菜单不能为空");
		}

		//菜单
		if(menu.getType() == Constant.MenuType.MENU.getValue()){
			if(StringUtils.isBlank(menu.getUrl())){
				throw new RRException("菜单URL不能为空");
			}
		}

		//上级菜单类型
		int parentType = Constant.MenuType.CATALOG.getValue();
		if(menu.getParentId() != 0){
			SysMenuEntity parentMenu = sysMenuService.queryObject(menu.getParentId());
			parentType = parentMenu.getType();
		}

		//目录、菜单
		if(menu.getType() == Constant.MenuType.CATALOG.getValue() ||
				menu.getType() == Constant.MenuType.MENU.getValue()){
			if(parentType != Constant.MenuType.CATALOG.getValue()){
				throw new RRException("上级菜单只能为目录类型");
			}
			return ;
		}

		//按钮
		if(menu.getType() == Constant.MenuType.BUTTON.getValue()){
			if(parentType != Constant.MenuType.MENU.getValue()){
				throw new RRException("上级菜单只能为菜单类型");
			}
			return ;
		}
	}

}
