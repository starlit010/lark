package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SysUserRoleEntity;
import com.gome.lark.role.service.SysUserRoleService;
import com.gome.lark.common.utils.PageUtils;
import com.gome.lark.common.utils.Query;
import com.gome.lark.common.utils.R;


/**
 * 用户与角色对应关系
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
@RestController
@RequestMapping("sysuserrole")
public class SysUserRoleController {
	@Autowired
	private SysUserRoleService sysUserRoleService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysuserrole:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysUserRoleEntity> sysUserRoleList = sysUserRoleService.queryList(query);
		int total = sysUserRoleService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysUserRoleList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sysuserrole:info")
	public R info(@PathVariable("id") Integer id){
		SysUserRoleEntity sysUserRole = sysUserRoleService.queryObject(id);
		
		return R.ok().put("sysUserRole", sysUserRole);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("sysuserrole:save")
	public R save(@RequestBody SysUserRoleEntity sysUserRole){
		sysUserRoleService.save(sysUserRole);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("sysuserrole:update")
	public R update(@RequestBody SysUserRoleEntity sysUserRole){
		sysUserRoleService.update(sysUserRole);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("sysuserrole:delete")
	public R delete(@RequestBody Integer[] ids){
		sysUserRoleService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
