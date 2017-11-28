package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SkillAutoqueryEntity;
import com.gome.lark.role.service.SkillAutoqueryService;
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
@RequestMapping("skillautoquery")
public class SkillAutoqueryController {
	@Autowired
	private SkillAutoqueryService skillAutoqueryService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("skillautoquery:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SkillAutoqueryEntity> skillAutoqueryList = skillAutoqueryService.queryList(query);
		int total = skillAutoqueryService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(skillAutoqueryList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("skillautoquery:info")
	public R info(@PathVariable("id") Integer id){
		SkillAutoqueryEntity skillAutoquery = skillAutoqueryService.queryObject(id);
		
		return R.ok().put("skillAutoquery", skillAutoquery);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("skillautoquery:save")
	public R save(@RequestBody SkillAutoqueryEntity skillAutoquery){
		skillAutoqueryService.save(skillAutoquery);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("skillautoquery:update")
	public R update(@RequestBody SkillAutoqueryEntity skillAutoquery){
		skillAutoqueryService.update(skillAutoquery);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("skillautoquery:delete")
	public R delete(@RequestBody Integer[] ids){
		skillAutoqueryService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
