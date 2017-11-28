package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SkillGroupEntity;
import com.gome.lark.role.service.SkillGroupService;
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
@RequestMapping("skillgroup")
public class SkillGroupController {
	@Autowired
	private SkillGroupService skillGroupService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("skillgroup:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SkillGroupEntity> skillGroupList = skillGroupService.queryList(query);
		int total = skillGroupService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(skillGroupList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{skillId}")
	@RequiresPermissions("skillgroup:info")
	public R info(@PathVariable("skillId") Integer skillId){
		SkillGroupEntity skillGroup = skillGroupService.queryObject(skillId);
		
		return R.ok().put("skillGroup", skillGroup);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("skillgroup:save")
	public R save(@RequestBody SkillGroupEntity skillGroup){
		skillGroupService.save(skillGroup);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("skillgroup:update")
	public R update(@RequestBody SkillGroupEntity skillGroup){
		skillGroupService.update(skillGroup);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("skillgroup:delete")
	public R delete(@RequestBody Integer[] skillIds){
		skillGroupService.deleteBatch(skillIds);
		
		return R.ok();
	}
	
}
