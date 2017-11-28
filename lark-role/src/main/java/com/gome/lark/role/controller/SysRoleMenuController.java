package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SysRoleMenuEntity;
import com.gome.lark.role.service.SysRoleMenuService;
import com.gome.lark.common.utils.PageUtils;
import com.gome.lark.common.utils.Query;
import com.gome.lark.common.utils.R;


/**
 * 角色与菜单对应关系
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
@RestController
@RequestMapping("sysrolemenu")
public class SysRoleMenuController {
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysrolemenu:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysRoleMenuEntity> sysRoleMenuList = sysRoleMenuService.queryList(query);
		int total = sysRoleMenuService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysRoleMenuList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sysrolemenu:info")
	public R info(@PathVariable("id") Integer id){
		SysRoleMenuEntity sysRoleMenu = sysRoleMenuService.queryObject(id);
		
		return R.ok().put("sysRoleMenu", sysRoleMenu);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("sysrolemenu:save")
	public R save(@RequestBody SysRoleMenuEntity sysRoleMenu){
		sysRoleMenuService.save(sysRoleMenu);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("sysrolemenu:update")
	public R update(@RequestBody SysRoleMenuEntity sysRoleMenu){
		sysRoleMenuService.update(sysRoleMenu);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("sysrolemenu:delete")
	public R delete(@RequestBody Integer[] ids){
		sysRoleMenuService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
