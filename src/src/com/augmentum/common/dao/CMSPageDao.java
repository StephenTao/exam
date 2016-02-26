package com.augmentum.common.dao;

import java.util.List;

import com.augmentum.common.dto.CMSPageDTO;
import com.augmentum.common.model.CMSPage;
import com.augmentum.common.mybatis.IBaseDao;

public interface CMSPageDao extends IBaseDao<CMSPage, Integer> {

    public CMSPageDTO getByUrl(String pageUrl);

    public List<CMSPageDTO> findCMSPages(String keywords);

}
