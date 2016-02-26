package com.augmentum.exam.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.QuestionOptionDao;
import com.augmentum.exam.model.QuestionOption;

@Repository("questionOptionDao")
public class QuestionOptionDaoImpl extends BaseDao<QuestionOption, Integer> implements QuestionOptionDao {

    private static final String CLASS_NAME = QuestionOption.class.getName();
    private static final String SQL_ID_FIND_BY_QUESTION_ID = ".findByQuestionId";
    private static final String SQL_ID_DELETE_BY_QUESTION_ID = ".deleteByQuestionId";

    @Override
    public List<QuestionOption> findByQuestionId(int questionId) {
        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FIND_BY_QUESTION_ID, questionId);
    }

    @Override
    public boolean deleteByQuestionId(int questionId) {
        getSqlSession().delete(CLASS_NAME + SQL_ID_DELETE_BY_QUESTION_ID, questionId);
        return true;
    }

}
