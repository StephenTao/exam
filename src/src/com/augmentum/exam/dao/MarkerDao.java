package com.augmentum.exam.dao;

import java.util.List;

import com.augmentum.common.mybatis.IBaseDao;
import com.augmentum.exam.model.Marker;
import com.augmentum.exam.model.User;

public interface MarkerDao extends IBaseDao<Marker, Integer> {

    boolean delete(Marker marker);

    List<User> getByExamId(int examId);
}
