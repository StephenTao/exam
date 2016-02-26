package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.PaperQuestionOptionDao;
import com.augmentum.exam.model.PaperQuestionOption;

@Repository("paperQuestionOptionDao")
public class PaperQuestionOptionDaoImpl extends BaseDao<PaperQuestionOption, Integer> implements PaperQuestionOptionDao {

}
