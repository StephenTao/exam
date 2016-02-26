package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.APIDao;
import com.augmentum.exam.model.API;

@Repository("apiDao")
public class APIDaoImpl extends BaseDao<API, Integer> implements APIDao {

}
