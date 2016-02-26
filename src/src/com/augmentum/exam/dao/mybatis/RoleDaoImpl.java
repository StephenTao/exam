package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.RoleDao;
import com.augmentum.exam.model.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDao<Role, Integer> implements RoleDao{

    private static final String CLASS_NAME = Role.class.getName();
    private static final String SQL_ID_GET_BY_CODE = ".getByCode";

    @Override
    public Role getByCode(String code) {
        return getSqlSession().selectOne(CLASS_NAME + SQL_ID_GET_BY_CODE, code);
    }
}
