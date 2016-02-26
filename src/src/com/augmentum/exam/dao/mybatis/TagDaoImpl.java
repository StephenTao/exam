package com.augmentum.exam.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.TagDao;
import com.augmentum.exam.model.Tag;

@Repository("tagDao")
public class TagDaoImpl extends BaseDao<Tag, Integer> implements TagDao {

    private static final String CLASS_NAME = Tag.class.getName();
    private static final String SQL_ID_FIND_ALL = ".findAll";
    private static final String SQL_NAME_FIND = ".findByName";

    @Override
    public List<Tag> findAll() {
        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FIND_ALL);
    }

    @Override
    public List<Tag> findByName(String name) {
        return getSqlSession().selectList(CLASS_NAME + SQL_NAME_FIND, name);
    }

}
