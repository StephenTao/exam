package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.ShowSizeDao;
import com.augmentum.exam.dto.ShowSizeDTO;
import com.augmentum.exam.model.ShowSize;
import com.augmentum.exam.service.ShowSizeService;

@Service("showSizeService")
public class ShowSizeServiceImpl extends BaseService implements ShowSizeService {

    @Resource
    private ShowSizeDao showSizeDao;

    @Override
    public int add(ShowSizeDTO showSizeDTO) throws ValidationException {
        validateObject(showSizeDTO);
        ShowSize showSize = (ShowSize) copyObject(showSizeDTO, ShowSize.class);
        showSizeDao.add(showSize);
        return showSize.getId();
    }

    @Override
    public boolean delete(int id) {
        return showSizeDao.delete(id);
    }

    @Override
    public boolean update(ShowSizeDTO showSizeDTO) throws ValidationException {
        if (showSizeDTO == null || showSizeDTO.getId() <= 0) {
            return false;
        }
        validateObject(showSizeDTO);
        ShowSize showSize = (ShowSize) copyObject(showSizeDTO, ShowSize.class);
        return showSizeDao.update(showSize);
    }

    @Override
    public ShowSizeDTO getById(int id) {
        ShowSize showSize = showSizeDao.getById(id);
        ShowSizeDTO showSizeDTO = (ShowSizeDTO) copyObject(showSize, ShowSizeDTO.class);
        return showSizeDTO;
    }

}
