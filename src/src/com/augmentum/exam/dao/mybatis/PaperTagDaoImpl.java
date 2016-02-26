package com.augmentum.exam.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.augmentum.common.mybatis.BaseDao;
import com.augmentum.exam.dao.PaperTagDao;
import com.augmentum.exam.model.PaperTag;
import com.augmentum.exam.model.Tag;

@Repository("paperTagDao")
public class PaperTagDaoImpl extends BaseDao<PaperTag, Integer> implements PaperTagDao {

    private static final String CLASS_NAME = PaperTag.class.getName();
    private static final String SQL_ID_DELETE = ".delete";
    private static final String SQL_ID_GET_BY_PAPER_ID = ".getByPaperId";

    @Override
    public boolean delete(PaperTag paperTag) {
        getSqlSession().delete(CLASS_NAME + SQL_ID_DELETE, paperTag);
        return true;
    }

    @Override
    public List<Tag> getByPaperId(int paperId) {
        List<Tag> tags = getSqlSession().selectList(CLASS_NAME + SQL_ID_GET_BY_PAPER_ID, paperId);
        return tags;
    }
}
