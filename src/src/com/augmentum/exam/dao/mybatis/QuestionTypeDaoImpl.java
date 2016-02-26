package com.augmentum.exam.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.QuestionTypeDao;
import com.augmentum.exam.model.QuestionType;

@Repository("questionTypeDao")
public class QuestionTypeDaoImpl extends BaseDao<QuestionType, Integer> implements QuestionTypeDao {

    private static final String CLASS_NAME = QuestionType.class.getName();
    private static final String SQL_ID_FIND_ALL = ".findAll";

    @Override
    public List<QuestionType> findAll() {
        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FIND_ALL);
    }

}
