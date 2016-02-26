package com.augmentum.exam.dao;

import java.util.List;

import com.augmentum.common.mybatis.IBaseDao;
import com.augmentum.exam.model.PaperTag;
import com.augmentum.exam.model.Tag;

public interface PaperTagDao extends IBaseDao<PaperTag, Integer> {

    boolean delete(PaperTag paperTag);

    List<Tag> getByPaperId(int paperId);
}
