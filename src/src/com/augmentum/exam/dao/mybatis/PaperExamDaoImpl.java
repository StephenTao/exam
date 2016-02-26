package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.PaperExamDao;
import com.augmentum.exam.model.PaperExam;

@Repository("paperExamDao")
public class PaperExamDaoImpl extends BaseDao<PaperExam, Integer> implements PaperExamDao {

}
