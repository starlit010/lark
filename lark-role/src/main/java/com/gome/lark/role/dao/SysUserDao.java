package com.gome.lark.role.dao;

import com.gome.lark.role.entity.SysUserEntity;
import com.gome.lark.common.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * 使用客服服务端回答访客问题的人
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SysUserDao extends BaseDao<SysUserEntity> {
    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(Integer userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Integer userId);

    /**
     * 根据用户名，查询系统用户
     */
    SysUserEntity queryByUserName(String username);

    /**
     * 修改密码
     */
    int updatePassword(Map<String, Object> map);
}
