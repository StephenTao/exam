package com.augmentum.common.dao;

import java.util.List;

import com.augmentum.common.dto.CMSBlockDTO;
import com.augmentum.common.model.CMSBlock;
import com.augmentum.common.mybatis.IBaseDao;

public interface CMSBlockDao extends IBaseDao<CMSBlock, Integer> {

    CMSBlockDTO getByName(String blockName);

    List<CMSBlockDTO> findCMSBlocks(String keywords);

}
