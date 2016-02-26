package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.LogHistoryDao;
import com.augmentum.exam.model.LogHistory;

@Repository("logHistoryDao")
public class LogHistoryDaoImpl extends BaseDao<LogHistory, Integer> implements LogHistoryDao {

}
