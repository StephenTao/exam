package com.augmentum.exam.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.ResourceDao;
import com.augmentum.exam.model.Resource;

@Repository("resourceDao")
public class ResourceDaoImpl extends BaseDao<Resource, Integer> implements ResourceDao {

}
