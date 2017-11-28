package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SysRoleDeptEntity;
import com.gome.lark.role.service.SysRoleDeptService;
import com.gome.lark.common.utils.PageUtils;
import com.gome.lark.common.utils.Query;
import com.gome.lark.common.utils.R;

/**
 * 角色与部门对应关系
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
@RestController
@RequestMapping("sysroledept")
public class SysRoleDeptController {
	@Autowired
	private SysRoleDeptService sysRoleDeptService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysroledept:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysRoleDeptEntity> sysRoleDeptList = sysRoleDeptService.queryList(query);
		int total = sysRoleDeptService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysRoleDeptList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sysroledept:info")
	public R info(@PathVariable("id") Integer id){
		SysRoleDeptEntity sysRoleDept = sysRoleDeptService.queryObject(id);
		
		return R.ok().put("sysRoleDept", sysRoleDept);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("sysroledept:save")
	public R save(@RequestBody SysRoleDeptEntity sysRoleDept){
		sysRoleDeptService.save(sysRoleDept);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("sysroledept:update")
	public R update(@RequestBody SysRoleDeptEntity sysRoleDept){
		sysRoleDeptService.update(sysRoleDept);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("sysroledept:delete")
	public R delete(@RequestBody Integer[] ids){
		sysRoleDeptService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
