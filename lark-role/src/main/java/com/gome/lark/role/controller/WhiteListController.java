package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.WhiteListEntity;
import com.gome.lark.role.service.WhiteListService;
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
@RequestMapping("whitelist")
public class WhiteListController {
	@Autowired
	private WhiteListService whiteListService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("whitelist:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WhiteListEntity> whiteListList = whiteListService.queryList(query);
		int total = whiteListService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(whiteListList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("whitelist:info")
	public R info(@PathVariable("id") Integer id){
		WhiteListEntity whiteList = whiteListService.queryObject(id);
		
		return R.ok().put("whiteList", whiteList);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("whitelist:save")
	public R save(@RequestBody WhiteListEntity whiteList){
		whiteListService.save(whiteList);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("whitelist:update")
	public R update(@RequestBody WhiteListEntity whiteList){
		whiteListService.update(whiteList);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("whitelist:delete")
	public R delete(@RequestBody Integer[] ids){
		whiteListService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
