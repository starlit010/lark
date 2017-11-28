package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.BusinessUserExtEntity;
import com.gome.lark.role.service.BusinessUserExtService;
import com.gome.lark.common.utils.PageUtils;
import com.gome.lark.common.utils.Query;
import com.gome.lark.common.utils.R;


/**
 * 
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:44
 */
@RestController
@RequestMapping("businessuserext")
public class BusinessUserExtController {
	@Autowired
	private BusinessUserExtService businessUserExtService;
	
	/**
	 * 列表
	 */
	@RequiresPermissions("businessuserext:list")
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BusinessUserExtEntity> businessUserExtList = businessUserExtService.queryList(query);
		int total = businessUserExtService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(businessUserExtList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequiresPermissions("businessuserext:info")
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		BusinessUserExtEntity businessUserExt = businessUserExtService.queryObject(id);
		
		return R.ok().put("businessUserExt", businessUserExt);
	}
	
	/**
	 * 保存
	 */
	@RequiresPermissions("businessuserext:save")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public R save(@RequestBody BusinessUserExtEntity businessUserExt){
		businessUserExtService.save(businessUserExt);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequiresPermissions("businessuserext:update")
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public R update(@RequestBody BusinessUserExtEntity businessUserExt){
		businessUserExtService.update(businessUserExt);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequiresPermissions("businessuserext:delete")
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public R delete(@RequestBody Integer[] ids){
		businessUserExtService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
