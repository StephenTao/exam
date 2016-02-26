package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.MessageHistoryDao;
import com.augmentum.exam.model.MessageHistory;

@Repository("messageHistoryDao")
public class MessageHistoryDaoImpl extends BaseDao<MessageHistory, Integer> implements MessageHistoryDao {

}
