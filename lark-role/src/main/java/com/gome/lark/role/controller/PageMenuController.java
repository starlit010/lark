package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.PageMenuEntity;
import com.gome.lark.role.service.PageMenuService;
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
@RequestMapping("pagemenu")
public class PageMenuController {
	@Autowired
	private PageMenuService pageMenuService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("pagemenu:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PageMenuEntity> pageMenuList = pageMenuService.queryList(query);
		int total = pageMenuService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(pageMenuList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{menuId}")
	@RequiresPermissions("pagemenu:info")
	public R info(@PathVariable("menuId") Integer menuId){
		PageMenuEntity pageMenu = pageMenuService.queryObject(menuId);
		
		return R.ok().put("pageMenu", pageMenu);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("pagemenu:save")
	public R save(@RequestBody PageMenuEntity pageMenu){
		pageMenuService.save(pageMenu);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("pagemenu:update")
	public R update(@RequestBody PageMenuEntity pageMenu){
		pageMenuService.update(pageMenu);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("pagemenu:delete")
	public R delete(@RequestBody Integer[] menuIds){
		pageMenuService.deleteBatch(menuIds);
		
		return R.ok();
	}
	
}
