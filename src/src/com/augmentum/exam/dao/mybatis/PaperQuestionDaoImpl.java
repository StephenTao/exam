package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.PaperQuestionDao;
import com.augmentum.exam.model.PaperQuestion;

@Repository("paperQuestionDao")
public class PaperQuestionDaoImpl extends BaseDao<PaperQuestion, Integer> implements PaperQuestionDao {

}
