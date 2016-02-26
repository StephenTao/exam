package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.LogDao;
import com.augmentum.exam.model.Log;

@Repository("logDao")
public class LogDaoImpl extends BaseDao<Log, Integer> implements LogDao {

}
