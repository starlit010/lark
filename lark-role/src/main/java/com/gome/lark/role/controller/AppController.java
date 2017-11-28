package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.AppEntity;
import com.gome.lark.role.service.AppService;
import com.gome.lark.common.utils.PageUtils;
import com.gome.lark.common.utils.Query;
import com.gome.lark.common.utils.R;


/**
 * 部门管理
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:44
 */
@RestController
@RequestMapping("app")
public class AppController {
	@Autowired
	private AppService appService;
	
	/**
	 * 列表
	 */
	@RequiresPermissions("app:list")
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AppEntity> appList = appService.queryList(query);
		int total = appService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(appList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequiresPermissions("app:info")
	@RequestMapping(value = "/info/{appId}",method = RequestMethod.GET)
	public R info(@PathVariable("appId") Integer appId){
		AppEntity app = appService.queryObject(appId);
		
		return R.ok().put("app", app);
	}
	
	/**
	 * 保存
	 */
	@RequiresPermissions("app:save")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public R save(@RequestBody AppEntity app){
		appService.save(app);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */

	@RequiresPermissions("app:update")
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public R update(@RequestBody AppEntity app){
		appService.update(app);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequiresPermissions("app:delete")
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public R delete(@RequestBody Integer[] appIds){
		appService.deleteBatch(appIds);
		
		return R.ok();
	}
	
}
