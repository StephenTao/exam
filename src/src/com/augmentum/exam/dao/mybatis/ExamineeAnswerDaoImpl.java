package com.augmentum.exam.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.Constants;
import com.augmentum.exam.dao.ExamineeAnswerDao;
import com.augmentum.exam.model.ExamineeAnswer;

@Repository("examineeAnswerDao")
public class ExamineeAnswerDaoImpl extends BaseDao<ExamineeAnswer, Integer> implements ExamineeAnswerDao {

    private static final String CLASS_NAME = ExamineeAnswer.class.getName();
    private static final String SQL_ID_GET_BY_EXAMINEE_ID = ".getByExamineeId";
    private static final String SQL_ID_GET_BY_ID = ".getByIds";

    @Override
    public List<ExamineeAnswer> getByExamineeId(int examineeId) {
        List<ExamineeAnswer> list = getSqlSession().selectList(CLASS_NAME + SQL_ID_GET_BY_EXAMINEE_ID, examineeId);
        return list;
    }

    @Override
    public ExamineeAnswer getByIds(int examineeId, int questionId) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(Constants.EXAMINEE_ID, examineeId);
        map.put(Constants.PAPER_QUESTION_ID, questionId);
        ExamineeAnswer answer = getSqlSession().selectOne(CLASS_NAME + SQL_ID_GET_BY_ID, map);
        return answer;
    }

}
