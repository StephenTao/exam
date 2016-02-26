package com.augmentum.exam.dao;

import java.util.List;

import com.augmentum.common.mybatis.IBaseDao;
import com.augmentum.exam.model.Tag;

public interface TagDao extends IBaseDao<Tag, Integer> {

    List<Tag> findAll();

    List<Tag> findByName(String name);

}
