package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.ShowSizeDao;
import com.augmentum.exam.model.ShowSize;

@Repository("showSizeDao")
public class ShowSizeDaoImpl extends BaseDao<ShowSize, Integer> implements ShowSizeDao {

}
