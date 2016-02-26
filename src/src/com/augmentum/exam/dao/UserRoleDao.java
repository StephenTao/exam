package com.augmentum.exam.dao;

import java.util.List;

import com.augmentum.common.mybatis.IBaseDao;
import com.augmentum.exam.model.Role;
import com.augmentum.exam.model.UserRole;

public interface UserRoleDao extends IBaseDao<UserRole, Integer> {

    boolean delete(UserRole userRole);

    List<Role> getByUserId(int userId);
}
