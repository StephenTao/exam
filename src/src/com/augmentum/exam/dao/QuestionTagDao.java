package com.augmentum.exam.dao;

import com.augmentum.common.mybatis.IBaseDao;
import com.augmentum.exam.model.QuestionTag;

public interface QuestionTagDao extends IBaseDao<QuestionTag, Integer> {

    QuestionTag getByIds(int questionId, int tagId);

    boolean deleteByIds(int questionId, int tagId);

}
