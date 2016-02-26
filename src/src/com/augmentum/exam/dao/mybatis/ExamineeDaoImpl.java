package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.ExamineeDao;
import com.augmentum.exam.model.Examinee;

@Repository("examineeDao")
public class ExamineeDaoImpl extends BaseDao<Examinee, Integer> implements ExamineeDao {

}
