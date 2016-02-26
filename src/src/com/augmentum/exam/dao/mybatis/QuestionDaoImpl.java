package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.QuestionDao;
import com.augmentum.exam.model.Question;

@Repository("questionDao")
public class QuestionDaoImpl extends BaseDao<Question, Integer> implements QuestionDao {
    private static final String SQL_QUESTION_ADD = ".addQuestion";
    @Override
    public int addQuestion(Question question) {
        return getSqlSession().insert(Question.class.getName() + SQL_QUESTION_ADD, question);
    }
}
