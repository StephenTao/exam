package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.MessageDao;
import com.augmentum.exam.model.Message;

@Repository("messageDao")
public class MessageDaoImpl extends BaseDao<Message, Integer> implements MessageDao {

}
