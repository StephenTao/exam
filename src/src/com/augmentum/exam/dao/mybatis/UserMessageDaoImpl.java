package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.UserMessageDao;
import com.augmentum.exam.model.UserMessage;

@Repository("userMessageDao")
public class UserMessageDaoImpl extends BaseDao<UserMessage, Integer> implements UserMessageDao {

}
