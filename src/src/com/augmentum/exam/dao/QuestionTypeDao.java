package com.augmentum.exam.dao;

import java.util.List;

import com.augmentum.common.mybatis.IBaseDao;
import com.augmentum.exam.model.QuestionType;

public interface QuestionTypeDao extends IBaseDao<QuestionType, Integer> {

    List<QuestionType> findAll();

}
