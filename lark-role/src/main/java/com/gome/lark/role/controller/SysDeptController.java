package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SysDeptEntity;
import com.gome.lark.role.service.SysDeptService;
import com.gome.lark.common.utils.PageUtils;
import com.gome.lark.common.utils.Query;
import com.gome.lark.common.utils.R;

/**
 * 部门管理
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
@RestController
@RequestMapping("sysdept")
public class SysDeptController {
	@Autowired
	private SysDeptService sysDeptService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysdept:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysDeptEntity> sysDeptList = sysDeptService.queryList(query);
		int total = sysDeptService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysDeptList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{deptId}")
	@RequiresPermissions("sysdept:info")
	public R info(@PathVariable("deptId") Integer deptId){
		SysDeptEntity sysDept = sysDeptService.queryObject(deptId);
		
		return R.ok().put("sysDept", sysDept);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("sysdept:save")
	public R save(@RequestBody SysDeptEntity sysDept){
		sysDeptService.save(sysDept);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("sysdept:update")
	public R update(@RequestBody SysDeptEntity sysDept){
		sysDeptService.update(sysDept);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("sysdept:delete")
	public R delete(@RequestBody Integer[] deptIds){
		sysDeptService.deleteBatch(deptIds);
		
		return R.ok();
	}
	
}
