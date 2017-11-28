package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SysChannelEntity;
import com.gome.lark.role.service.SysChannelService;
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
@RequestMapping("syschannel")
public class SysChannelController {
	@Autowired
	private SysChannelService sysChannelService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("channel:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysChannelEntity> channelList = sysChannelService.queryList(query);
		int total = sysChannelService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(channelList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{channelId}")
	@RequiresPermissions("channel:info")
	public R info(@PathVariable("channelId") Integer channelId){
		SysChannelEntity channel = sysChannelService.queryObject(channelId);
		
		return R.ok().put("channel", channel);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("channel:save")
	public R save(@RequestBody SysChannelEntity channel){
		sysChannelService.save(channel);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("channel:update")
	public R update(@RequestBody SysChannelEntity channel){
		sysChannelService.update(channel);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("channel:delete")
	public R delete(@RequestBody Integer[] channelIds){
		sysChannelService.deleteBatch(channelIds);
		
		return R.ok();
	}
	
}
