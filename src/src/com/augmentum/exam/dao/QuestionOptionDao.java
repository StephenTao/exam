package com.augmentum.exam.dao;

import java.util.List;

import com.augmentum.common.mybatis.IBaseDao;
import com.augmentum.exam.model.QuestionOption;

public interface QuestionOptionDao extends IBaseDao<QuestionOption, Integer> {

    List<QuestionOption> findByQuestionId(int questionId);

    boolean deleteByQuestionId(int questionId);

}
