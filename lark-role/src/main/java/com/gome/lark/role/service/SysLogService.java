package com.gome.lark.role.service;

import com.gome.lark.role.entity.SysLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SysLogService {
	
	SysLogEntity queryObject(Integer id);
	
	List<SysLogEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysLogEntity sysLog);
	
	void update(SysLogEntity sysLog);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
