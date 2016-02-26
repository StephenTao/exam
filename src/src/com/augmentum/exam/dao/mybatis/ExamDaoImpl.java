package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.ExamDao;
import com.augmentum.exam.model.Exam;

@Repository("examDao")
public class ExamDaoImpl extends BaseDao<Exam, Integer> implements ExamDao {

}
