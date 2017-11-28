package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.SupplierUserExtEntity;
import com.gome.lark.role.service.SupplierUserExtService;
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
@RequestMapping("supplieruserext")
public class SupplierUserExtController {
	@Autowired
	private SupplierUserExtService supplierUserExtService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("supplieruserext:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SupplierUserExtEntity> supplierUserExtList = supplierUserExtService.queryList(query);
		int total = supplierUserExtService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(supplierUserExtList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("supplieruserext:info")
	public R info(@PathVariable("id") Integer id){
		SupplierUserExtEntity supplierUserExt = supplierUserExtService.queryObject(id);
		
		return R.ok().put("supplierUserExt", supplierUserExt);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("supplieruserext:save")
	public R save(@RequestBody SupplierUserExtEntity supplierUserExt){
		supplierUserExtService.save(supplierUserExt);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("supplieruserext:update")
	public R update(@RequestBody SupplierUserExtEntity supplierUserExt){
		supplierUserExtService.update(supplierUserExt);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("supplieruserext:delete")
	public R delete(@RequestBody Integer[] ids){
		supplierUserExtService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
