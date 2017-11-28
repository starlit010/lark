package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.DeptAppEntity;
import com.gome.lark.role.service.DeptAppService;
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
@RequestMapping("deptapp")
public class DeptAppController {
	@Autowired
	private DeptAppService deptAppService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("deptapp:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<DeptAppEntity> deptAppList = deptAppService.queryList(query);
		int total = deptAppService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(deptAppList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("deptapp:info")
	public R info(@PathVariable("id") Integer id){
		DeptAppEntity deptApp = deptAppService.queryObject(id);
		
		return R.ok().put("deptApp", deptApp);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("deptapp:save")
	public R save(@RequestBody DeptAppEntity deptApp){
		deptAppService.save(deptApp);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("deptapp:update")
	public R update(@RequestBody DeptAppEntity deptApp){
		deptAppService.update(deptApp);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("deptapp:delete")
	public R delete(@RequestBody Integer[] ids){
		deptAppService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
