package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SysConfigEntity;
import com.gome.lark.role.service.SysConfigService;
import com.gome.lark.common.utils.PageUtils;
import com.gome.lark.common.utils.Query;
import com.gome.lark.common.utils.R;


/**
 * 默认头像
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
@RestController
@RequestMapping("sysconfig")
public class SysConfigController {
	@Autowired
	private SysConfigService sysConfigService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysconfig:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysConfigEntity> sysConfigList = sysConfigService.queryList(query);
		int total = sysConfigService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysConfigList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sysconfig:info")
	public R info(@PathVariable("id") Integer id){
		SysConfigEntity sysConfig = sysConfigService.queryObject(id);
		
		return R.ok().put("sysConfig", sysConfig);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("sysconfig:save")
	public R save(@RequestBody SysConfigEntity sysConfig){
		sysConfigService.save(sysConfig);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("sysconfig:update")
	public R update(@RequestBody SysConfigEntity sysConfig){
		sysConfigService.update(sysConfig);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("sysconfig:delete")
	public R delete(@RequestBody Integer[] ids){
		sysConfigService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
