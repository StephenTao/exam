package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.UserTagDao;
import com.augmentum.exam.model.UserTag;

@Repository("userTagDao")
public class UserTagDaoImpl extends BaseDao<UserTag, Integer> implements UserTagDao {

}
