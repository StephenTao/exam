package com.augmentum.exam.dao.mybatis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.Constants;
import com.augmentum.exam.dao.QuestionTagDao;
import com.augmentum.exam.model.QuestionTag;

@Repository("questionTagDao")
public class QuestionTagDaoImpl extends BaseDao<QuestionTag, Integer> implements QuestionTagDao {

    private static final String CLASS_NAME = QuestionTag.class.getName();
    private static final String SQL_ID_GET_BY_IDS = ".getByIds";
    private static final String SQL_ID_DELETE_BY_IDS = ".deleteByIds";

    @Override
    public QuestionTag getByIds(int questionId, int tagId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(Constants.QUESTION_ID, questionId);
        params.put(Constants.TAG_ID, tagId);
        return getSqlSession().selectOne(CLASS_NAME + SQL_ID_GET_BY_IDS, params);
    }

    @Override
    public boolean deleteByIds(int questionId, int tagId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(Constants.QUESTION_ID, questionId);
        params.put(Constants.TAG_ID, tagId);
        getSqlSession().delete(CLASS_NAME + SQL_ID_DELETE_BY_IDS, params);
        return true;
    }

}
