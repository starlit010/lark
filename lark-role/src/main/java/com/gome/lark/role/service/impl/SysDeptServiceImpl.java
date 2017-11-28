package com.gome.lark.role.service.impl;

import com.qiniu.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gome.lark.role.dao.SysDeptDao;
import com.gome.lark.role.entity.SysDeptEntity;
import com.gome.lark.role.service.SysDeptService;



@Service("sysDeptService")
public class SysDeptServiceImpl implements SysDeptService {
	@Autowired
	private SysDeptDao sysDeptDao;
	
	@Override
	public SysDeptEntity queryObject(Integer deptId){
		return sysDeptDao.queryObject(deptId);
	}
	
	@Override
	public List<SysDeptEntity> queryList(Map<String, Object> map){
		return sysDeptDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysDeptDao.queryTotal(map);
	}
	
	@Override
	public void save(SysDeptEntity sysDept){
		sysDeptDao.save(sysDept);
	}
	
	@Override
	public void update(SysDeptEntity sysDept){
		sysDeptDao.update(sysDept);
	}
	
	@Override
	public void delete(Integer deptId){
		sysDeptDao.delete(deptId);
	}
	
	@Override
	public void deleteBatch(Integer[] deptIds){
		sysDeptDao.deleteBatch(deptIds);
	}

	@Override
	public List<Integer> queryDetpIdList(Integer parentId) {
		return sysDeptDao.queryDetpIdList(parentId);
	}

	@Override
	public String getSubDeptIdList(Integer deptId){
		//部门及子部门ID列表
		List<Integer> deptIdList = new ArrayList<>();

		//获取子部门ID
		List<Integer> subIdList = queryDetpIdList(deptId);
		getDeptTreeList(subIdList, deptIdList);

		//添加本部门
		deptIdList.add(deptId);

		String deptFilter = StringUtils.join(deptIdList, ",");
		return deptFilter;
	}

	/**
	 * 递归
	 */
	private void getDeptTreeList(List<Integer> subIdList, List<Integer> deptIdList){
		for(Integer deptId : subIdList){
			List<Integer> list = queryDetpIdList(deptId);
			if(list.size() > 0){
				getDeptTreeList(list, deptIdList);
			}

			deptIdList.add(deptId);
		}
	}

}
