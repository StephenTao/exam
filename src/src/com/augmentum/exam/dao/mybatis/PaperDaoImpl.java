package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.PaperDao;
import com.augmentum.exam.model.Paper;

@Repository("paperDao")
public class PaperDaoImpl extends BaseDao<Paper, Integer> implements PaperDao {

}
