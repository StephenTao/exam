package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.UserDao;
import com.augmentum.exam.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDao<User, Integer> implements UserDao {

    private static final String CLASS_NAME = User.class.getName();
    private static final String SQL_ID_GET_BY_NAME = ".getByName";

    @Override
    public User getByName(String name) {
        return getSqlSession().selectOne(CLASS_NAME + SQL_ID_GET_BY_NAME, name);
    }

}
