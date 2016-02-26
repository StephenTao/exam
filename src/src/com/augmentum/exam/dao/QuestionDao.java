package com.augmentum.exam.dao;

import com.augmentum.common.mybatis.IBaseDao;
import com.augmentum.exam.model.Question;

public interface QuestionDao extends IBaseDao<Question, Integer> {
    public int addQuestion(Question question);
}
