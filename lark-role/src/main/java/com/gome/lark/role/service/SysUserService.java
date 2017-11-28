package com.gome.lark.role.service;

import com.gome.lark.role.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 使用客服服务端回答访客问题的人
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SysUserService {
	
	void delete(Integer userId);
	
	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Integer userId);

	/**
	 * 查询用户的所有菜单ID
	 */
	List<Integer> queryAllMenuId(Integer userId);

	/**
	 * 根据用户名，查询系统用户
	 */
	SysUserEntity queryByUserName(String username);

	/**
	 * 根据用户ID，查询用户
	 * @param userId
	 * @return
	 */
	SysUserEntity queryObject(Integer userId);

	/**
	 * 查询用户列表
	 */
	List<SysUserEntity> queryList(Map<String, Object> map);

	/**
	 * 查询总数
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 保存用户
	 */
	void save(SysUserEntity user);

	/**
	 * 修改用户
	 */
	void update(SysUserEntity user);

	/**
	 * 删除用户
	 */
	void deleteBatch(Integer[] userIds);

	/**
	 * 修改密码
	 * @param userId       用户ID
	 * @param password     原密码
	 * @param newPassword  新密码
	 */
	int updatePassword(Integer userId, String password, String newPassword);
}
