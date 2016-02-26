package com.augmentum.common.service;

import java.util.List;

import com.augmentum.common.dto.CMSPageDTO;
import com.augmentum.common.exception.BusinessException;
import com.augmentum.common.exception.ValidationException;

public interface CMSPageService {

    public CMSPageDTO getCMSPageByUrl(String pageUrl);

    public Boolean addCMSPage(CMSPageDTO cmsPageDTO) throws ValidationException, BusinessException;

    public Integer updateCMSPage(CMSPageDTO cmsPageDTO) throws ValidationException;

    public Boolean deleteCMSPage(Integer pageId);

    public CMSPageDTO getCMSPageById(Integer pageId);

    public List<CMSPageDTO> findCMSPages(String keywords);

}
