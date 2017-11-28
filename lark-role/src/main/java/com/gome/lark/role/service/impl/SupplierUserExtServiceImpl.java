package com.gome.lark.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SupplierUserExtDao;
import com.gome.lark.role.entity.SupplierUserExtEntity;
import com.gome.lark.role.service.SupplierUserExtService;



@Service("supplierUserExtService")
public class SupplierUserExtServiceImpl implements SupplierUserExtService {
	@Autowired
	private SupplierUserExtDao supplierUserExtDao;
	
	@Override
	public SupplierUserExtEntity queryObject(Integer id){
		return supplierUserExtDao.queryObject(id);
	}
	
	@Override
	public List<SupplierUserExtEntity> queryList(Map<String, Object> map){
		return supplierUserExtDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return supplierUserExtDao.queryTotal(map);
	}
	
	@Override
	public void save(SupplierUserExtEntity supplierUserExt){
		supplierUserExtDao.save(supplierUserExt);
	}
	
	@Override
	public void update(SupplierUserExtEntity supplierUserExt){
		supplierUserExtDao.update(supplierUserExt);
	}
	
	@Override
	public void delete(Integer id){
		supplierUserExtDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		supplierUserExtDao.deleteBatch(ids);
	}
	
}
