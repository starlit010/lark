package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.BusinessUserExtDao;
import com.gome.lark.role.entity.BusinessUserExtEntity;
import com.gome.lark.role.service.BusinessUserExtService;



@Service("businessUserExtService")
public class BusinessUserExtServiceImpl implements BusinessUserExtService {
	@Autowired
	private BusinessUserExtDao businessUserExtDao;
	
	@Override
	public BusinessUserExtEntity queryObject(Integer id){
		return businessUserExtDao.queryObject(id);
	}
	
	@Override
	public List<BusinessUserExtEntity> queryList(Map<String, Object> map){
		return businessUserExtDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return businessUserExtDao.queryTotal(map);
	}
	
	@Override
	public void save(BusinessUserExtEntity businessUserExt){
		businessUserExtDao.save(businessUserExt);
	}
	
	@Override
	public void update(BusinessUserExtEntity businessUserExt){
		businessUserExtDao.update(businessUserExt);
	}
	
	@Override
	public void delete(Integer id){
		businessUserExtDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		businessUserExtDao.deleteBatch(ids);
	}
	
}
