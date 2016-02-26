package com.augmentum.exam.dao;

import com.augmentum.common.mybatis.IBaseDao;
import com.augmentum.exam.model.Role;

public interface RoleDao extends IBaseDao<Role, Integer> {

    Role getByCode(String roleCode);

}
