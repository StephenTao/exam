package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.PaperPartDao;
import com.augmentum.exam.model.PaperPart;

@Repository("paperPartDao")
public class PaperPartDaoImpl extends BaseDao<PaperPart, Integer> implements PaperPartDao {

}
