package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SkillMappingEntity;
import com.gome.lark.role.service.SkillMappingService;
import com.gome.lark.common.utils.PageUtils;
import com.gome.lark.common.utils.Query;
import com.gome.lark.common.utils.R;


/**
 * 
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
@RestController
@RequestMapping("skillmapping")
public class SkillMappingController {
	@Autowired
	private SkillMappingService skillMappingService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("skillmapping:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SkillMappingEntity> skillMappingList = skillMappingService.queryList(query);
		int total = skillMappingService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(skillMappingList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("skillmapping:info")
	public R info(@PathVariable("id") Integer id){
		SkillMappingEntity skillMapping = skillMappingService.queryObject(id);
		
		return R.ok().put("skillMapping", skillMapping);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("skillmapping:save")
	public R save(@RequestBody SkillMappingEntity skillMapping){
		skillMappingService.save(skillMapping);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("skillmapping:update")
	public R update(@RequestBody SkillMappingEntity skillMapping){
		skillMappingService.update(skillMapping);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("skillmapping:delete")
	public R delete(@RequestBody Integer[] ids){
		skillMappingService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
