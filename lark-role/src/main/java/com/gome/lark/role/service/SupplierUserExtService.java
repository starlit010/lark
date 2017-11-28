package com.gome.lark.role.service;

import com.gome.lark.role.entity.SupplierUserExtEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SupplierUserExtService {
	
	SupplierUserExtEntity queryObject(Integer id);
	
	List<SupplierUserExtEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SupplierUserExtEntity supplierUserExt);
	
	void update(SupplierUserExtEntity supplierUserExt);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
