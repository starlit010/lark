package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SysRoleEntity;
import com.gome.lark.role.service.SysRoleService;
import com.gome.lark.common.utils.PageUtils;
import com.gome.lark.common.utils.Query;
import com.gome.lark.common.utils.R;


/**
 * 角色
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
@RestController
@RequestMapping("sysrole")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	
	/**
	 * 列表
	 */
	@RequiresPermissions("sysrole:list")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysRoleEntity> sysRoleList = sysRoleService.queryList(query);
		int total = sysRoleService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysRoleList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value = "/info/{roleId}", method = RequestMethod.GET)
	@RequiresPermissions("sysrole:info")
	public R info(@PathVariable("roleId") Integer roleId){
		SysRoleEntity sysRole = sysRoleService.queryObject(roleId);
		
		return R.ok().put("sysRole", sysRole);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("sysrole:save")
	public R save(@RequestBody SysRoleEntity sysRole){
		sysRoleService.save(sysRole);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("sysrole:update")
	public R update(@RequestBody SysRoleEntity sysRole){
		sysRoleService.update(sysRole);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("sysrole:delete")
	public R delete(@RequestBody Integer[] roleIds){
		sysRoleService.deleteBatch(roleIds);
		
		return R.ok();
	}
	
}
