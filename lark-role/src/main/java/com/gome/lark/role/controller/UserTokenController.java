package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.UserTokenEntity;
import com.gome.lark.role.service.UserTokenService;
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
@RequestMapping("usertoken")
public class UserTokenController {
	@Autowired
	private UserTokenService userTokenService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("usertoken:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<UserTokenEntity> userTokenList = userTokenService.queryList(query);
		int total = userTokenService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userTokenList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("usertoken:info")
	public R info(@PathVariable("userId") Integer userId){
		UserTokenEntity userToken = userTokenService.queryObject(userId);
		
		return R.ok().put("userToken", userToken);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("usertoken:save")
	public R save(@RequestBody UserTokenEntity userToken){
		userTokenService.save(userToken);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("usertoken:update")
	public R update(@RequestBody UserTokenEntity userToken){
		userTokenService.update(userToken);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("usertoken:delete")
	public R delete(@RequestBody Integer[] userIds){
		userTokenService.deleteBatch(userIds);
		
		return R.ok();
	}
	
}
