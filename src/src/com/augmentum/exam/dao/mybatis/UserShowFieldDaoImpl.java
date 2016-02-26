package com.augmentum.exam.dao.mybatis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.Constants;
import com.augmentum.exam.dao.UserShowFieldDao;
import com.augmentum.exam.model.UserShowField;

@Repository("userShowFieldDao")
public class UserShowFieldDaoImpl extends BaseDao<UserShowField, Integer> implements UserShowFieldDao {

    private static final String CLASS_NAME = UserShowField.class.getName();
    private static final String SQL_ID_GET_BY_IDS = ".getByIds";
    private static final String SQL_ID_DELETE_BY_IDS = ".deleteByIds";

    @Override
    public UserShowField getByIds(int userId, int showFieldId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(Constants.USER_ID, userId);
        params.put(Constants.SHOW_FIELD_ID, showFieldId);
        return getSqlSession().selectOne(CLASS_NAME + SQL_ID_GET_BY_IDS, params);
    }

    @Override
    public boolean deleteByIds(int userId, int showFieldId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(Constants.USER_ID, userId);
        params.put(Constants.SHOW_FIELD_ID, showFieldId);
        getSqlSession().delete(CLASS_NAME + SQL_ID_DELETE_BY_IDS, params);
        return true;
    }

}
