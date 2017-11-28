package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SkillGroupUserEntity;
import com.gome.lark.role.service.SkillGroupUserService;
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
@RequestMapping("skillgroupuser")
public class SkillGroupUserController {
	@Autowired
	private SkillGroupUserService skillGroupUserService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("skillgroupuser:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SkillGroupUserEntity> skillGroupUserList = skillGroupUserService.queryList(query);
		int total = skillGroupUserService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(skillGroupUserList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("skillgroupuser:info")
	public R info(@PathVariable("id") Integer id){
		SkillGroupUserEntity skillGroupUser = skillGroupUserService.queryObject(id);
		
		return R.ok().put("skillGroupUser", skillGroupUser);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("skillgroupuser:save")
	public R save(@RequestBody SkillGroupUserEntity skillGroupUser){
		skillGroupUserService.save(skillGroupUser);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("skillgroupuser:update")
	public R update(@RequestBody SkillGroupUserEntity skillGroupUser){
		skillGroupUserService.update(skillGroupUser);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("skillgroupuser:delete")
	public R delete(@RequestBody Integer[] ids){
		skillGroupUserService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
