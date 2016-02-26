package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.MessageTypeDao;
import com.augmentum.exam.model.MessageType;

@Repository("messageTypeDao")
public class MessageTypeDaoImpl extends BaseDao<MessageType, Integer> implements MessageTypeDao {

}
