package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.QuestionCommentDao;
import com.augmentum.exam.model.QuestionComment;

@Repository("questionComment")
public class QuestionCommentDaoImpl extends BaseDao<QuestionComment, Integer> implements QuestionCommentDao {

}
