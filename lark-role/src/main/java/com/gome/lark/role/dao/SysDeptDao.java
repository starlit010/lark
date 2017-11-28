package com.gome.lark.role.dao;

import com.gome.lark.role.entity.SysDeptEntity;
import com.gome.lark.common.dao.BaseDao;

import java.util.List;

/**
 * 部门管理
 * 
 * @author liuhui-ds9
 * @email liuhui-ds9@gomeplus.com.cn
 * @date 2017-11-23 16:06:45
 */
public interface SysDeptDao extends BaseDao<SysDeptEntity> {

    /**
     * 查询子部门ID列表
     * @param parentId  上级部门ID
     */
    List<Integer> queryDetpIdList(Integer parentId);

}
