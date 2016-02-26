package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.QuestionCopyDao;
import com.augmentum.exam.model.QuestionCopy;

@Repository("questionCopyDao")
public class QuestionCopyDaoImpl extends BaseDao<QuestionCopy, Integer> implements QuestionCopyDao {

}
