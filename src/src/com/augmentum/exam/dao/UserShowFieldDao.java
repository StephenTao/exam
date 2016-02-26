package com.augmentum.exam.dao;

import com.augmentum.common.mybatis.IBaseDao;
import com.augmentum.exam.model.UserShowField;

public interface UserShowFieldDao extends IBaseDao<UserShowField, Integer> {

    UserShowField getByIds(int userId, int showFieldId);

    boolean deleteByIds(int userId, int showFieldId);

}
