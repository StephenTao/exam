package com.augmentum.common.mybatis;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.augmentum.common.AppConstants;
import com.augmentum.common.dto.PaginationDTO;
import com.augmentum.exam.EContext;

@Repository("baseDao")
public abstract class BaseDao<T, K> extends SqlSessionDaoSupport {

    protected static String SQL_ID_ADD = ".add";
    protected static String SQL_ID_UPDATE = ".update";
    protected static String SQL_ID_DELETE = ".delete";
    protected static String SQL_ID_BY_ID = ".getById";
    private static final String KEY_OFFSET = "offset";
    private static final String KEY_ROW_COUNT = "rowCount";
    private Class<T> clz;

    @Resource
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @SuppressWarnings("unchecked")
    protected Class<T> getClz() {
        if (clz == null)
            clz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clz;
    }

    public boolean add(T obj) {
        getSqlSession().insert(this.getClz().getName() + SQL_ID_ADD, obj);
        return true;
    }

    public boolean delete(K id) {
        getSqlSession().delete(this.getClz().getName() + SQL_ID_DELETE, id);
        return true;
    }

    public boolean update(T obj) {
        getSqlSession().update(this.getClz().getName() + SQL_ID_UPDATE, obj);
        return true;
    }

    @SuppressWarnings("unchecked")
    public T getById(K id) {
        return (T) getSqlSession().selectOne(this.getClz().getName() + SQL_ID_BY_ID, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findByQueryId(String sqlId, Object parameters) {
        return (List<T>) getSqlSession().selectList(this.getClz().getName() + sqlId, parameters);
    }

    protected Map<String, Object> getParameterMap() {
        Map<String, Object> parameterMap = null;
        PaginationDTO<?> paginationDTO = (PaginationDTO<?>) EContext.getContext().getObject(
                AppConstants.PAGINATION_DTO);
        if (paginationDTO == null) {
            // don't need to pagination
            parameterMap = new HashMap<String, Object>();
        } else {
            parameterMap = paginationDTO.getParameterMap();
            parameterMap.put(KEY_OFFSET, paginationDTO.getOffset());
            parameterMap.put(KEY_ROW_COUNT, paginationDTO.getRowCount());
        }
        return parameterMap;
    }
}