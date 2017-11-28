package com.gome.lark.role.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gome.lark.role.entity.CompanyEntity;
import com.gome.lark.role.service.CompanyService;
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
@RequestMapping("company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("company:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CompanyEntity> companyList = companyService.queryList(query);
		int total = companyService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(companyList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("company:info")
	public R info(@PathVariable("id") Integer id){
		CompanyEntity company = companyService.queryObject(id);
		
		return R.ok().put("company", company);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@RequiresPermissions("company:save")
	public R save(@RequestBody CompanyEntity company){
		companyService.save(company);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@RequiresPermissions("company:update")
	public R update(@RequestBody CompanyEntity company){
		companyService.update(company);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@RequiresPermissions("company:delete")
	public R delete(@RequestBody Integer[] ids){
		companyService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
