package com.gome.lark.role.service;

import com.gome.lark.role.entity.BusinessUserExtEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:44
 */
public interface BusinessUserExtService {
	
	BusinessUserExtEntity queryObject(Integer id);
	
	List<BusinessUserExtEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BusinessUserExtEntity businessUserExt);
	
	void update(BusinessUserExtEntity businessUserExt);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
