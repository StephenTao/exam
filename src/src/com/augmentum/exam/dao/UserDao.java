package com.augmentum.exam.dao;

import com.augmentum.common.mybatis.IBaseDao;
import com.augmentum.exam.model.User;

public interface UserDao extends IBaseDao <User, Integer> {

    User getByName(String name);

}
