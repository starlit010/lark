package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SysUserEntity;
import com.gome.lark.role.service.SysUserService;
import com.gome.lark.common.utils.PageUtils;
import com.gome.lark.common.utils.Query;
import com.gome.lark.common.utils.R;


/**
 * 使用客服服务端回答访客问题的人
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController{
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysuser:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysUserEntity> sysUserList = sysUserService.queryList(query);
		int total = sysUserService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysUserList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	public R info(){
		return R.ok().put("user", getUser());
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("sysuser:info")
	public R info(@PathVariable("userId") Integer userId){
		SysUserEntity sysUser = sysUserService.queryObject(userId);
		
		return R.ok().put("sysUser", sysUser);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("sysuser:save")
	public R save(@RequestBody SysUserEntity sysUser){
		sysUserService.save(sysUser);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("sysuser:update")
	public R update(@RequestBody SysUserEntity sysUser){
		sysUserService.update(sysUser);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("sysuser:delete")
	public R delete(@RequestBody Integer[] userIds){
		sysUserService.deleteBatch(userIds);
		
		return R.ok();
	}
	
}
