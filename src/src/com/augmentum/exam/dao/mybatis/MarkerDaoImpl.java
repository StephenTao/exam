package com.augmentum.exam.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.MarkerDao;
import com.augmentum.exam.model.Marker;
import com.augmentum.exam.model.User;

@Repository("markerDao")
public class MarkerDaoImpl extends BaseDao<Marker, Integer> implements MarkerDao {

    private static final String CLASS_NAME = Marker.class.getName();
    private static final String SQL_ID_DELETE = ".delete";
    private static final String SQL_ID_GET_BY_EXAM_ID = ".getByExamId";

    @Override
    public boolean delete(Marker marker) {
        getSqlSession().delete(CLASS_NAME + SQL_ID_DELETE, marker);
        return true;
    }

    @Override
    public List<User> getByExamId(int examId) {
        List<User> users = getSqlSession().selectList(CLASS_NAME + SQL_ID_GET_BY_EXAM_ID, examId);
        return users;
    }
}
