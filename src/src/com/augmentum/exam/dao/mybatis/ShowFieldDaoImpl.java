package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.ShowFieldDao;
import com.augmentum.exam.model.ShowField;

@Repository("showFieldDao")
public class ShowFieldDaoImpl extends BaseDao<ShowField, Integer> implements ShowFieldDao {

}
