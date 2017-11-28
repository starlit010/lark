package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import com.gome.lark.common.utils.PageUtils;
import com.gome.lark.common.utils.Query;
import com.gome.lark.common.utils.R;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SysLogEntity;
import com.gome.lark.role.service.SysLogService;


/**
 * 系统日志
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
@RestController
@RequestMapping("syslog")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("syslog:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysLogEntity> sysLogList = sysLogService.queryList(query);
		int total = sysLogService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysLogList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("syslog:info")
	public R info(@PathVariable("id") Integer id){
		SysLogEntity sysLog = sysLogService.queryObject(id);
		
		return R.ok().put("sysLog", sysLog);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("syslog:save")
	public R save(@RequestBody SysLogEntity sysLog){
		sysLogService.save(sysLog);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("syslog:update")
	public R update(@RequestBody SysLogEntity sysLog){
		sysLogService.update(sysLog);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("syslog:")
	public R delete(@RequestBody Integer[] ids){
		sysLogService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
