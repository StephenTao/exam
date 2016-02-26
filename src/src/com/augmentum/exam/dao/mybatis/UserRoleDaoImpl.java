package com.augmentum.exam.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.UserRoleDao;
import com.augmentum.exam.model.Role;
import com.augmentum.exam.model.UserRole;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends BaseDao<UserRole, Integer> implements UserRoleDao {

    private static final String CLASS_NAME = UserRole.class.getName();
    private static final String SQL_ID_DELETE = ".delete";
    private static final String SQL_ID_GET_BY_USER_ID = ".getByUserId";

    @Override
    public boolean delete(UserRole userRole) {
        getSqlSession().delete(CLASS_NAME + SQL_ID_DELETE, userRole);
        return true;
    }

    @Override
    public List<Role> getByUserId(int userId) {
        List<Role> roles = getSqlSession().selectList(CLASS_NAME + SQL_ID_GET_BY_USER_ID, userId);
        return roles;
    }
}
