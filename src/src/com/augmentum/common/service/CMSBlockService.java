package com.augmentum.common.service;

import java.util.List;
import java.util.Map;

import com.augmentum.common.dto.CMSBlockDTO;
import com.augmentum.common.exception.BusinessException;
import com.augmentum.common.exception.ValidationException;

public interface CMSBlockService {

    Map<String, String> addCMSBlock(CMSBlockDTO cmsBlockDTO) throws ValidationException, BusinessException;

    Map<String, String> updateCMSBlock(CMSBlockDTO cmsBlockDTO) throws ValidationException, BusinessException;

    CMSBlockDTO getCMSBlockByName(String blockName);

    Boolean deleteCMSBlock(Integer blockId);

    CMSBlockDTO getCMSBlockById(Integer blockId);

    List<CMSBlockDTO> findCMSBlocks(String keywords);

}
