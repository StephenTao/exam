package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.UserAPIDao;
import com.augmentum.exam.model.UserAPI;

@Repository("userAPIDao")
public class UserAPIDaoImpl extends BaseDao<UserAPI, Integer> implements UserAPIDao {

}
