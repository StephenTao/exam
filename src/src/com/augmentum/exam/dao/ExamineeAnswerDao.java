package com.augmentum.exam.dao;

import java.util.List;

import com.augmentum.common.mybatis.IBaseDao;
import com.augmentum.exam.model.ExamineeAnswer;

public interface ExamineeAnswerDao extends IBaseDao<ExamineeAnswer, Integer> {

    List<ExamineeAnswer> getByExamineeId(int examineeId);

    ExamineeAnswer getByIds(int examineeId, int questionId);
}
