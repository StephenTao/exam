package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.ShowFieldDao;
import com.augmentum.exam.dto.ShowFieldDTO;
import com.augmentum.exam.model.ShowField;
import com.augmentum.exam.service.ShowFieldService;

@Service("showFieldService")
public class ShowFieldServiceImpl extends BaseService implements ShowFieldService {

    @Resource
    private ShowFieldDao showFieldDao;

    @Override
    public int add(ShowFieldDTO showFieldDTO) throws ValidationException {
        validateObject(showFieldDTO);
        ShowField showField = (ShowField) copyObject(showFieldDTO, ShowField.class);
        showFieldDao.add(showField);
        return showField.getId();
    }

    @Override
    public boolean delete(int id) {
        boolean result = showFieldDao.delete(id);
        return result;
    }

    @Override
    public boolean update(ShowFieldDTO showFieldDTO) throws ValidationException {
        if(showFieldDTO == null || showFieldDTO.getId() <= 0) {
            return false;
        }
        validateObject(showFieldDTO);
        ShowField showField = (ShowField) copyObject(showFieldDTO, ShowField.class);
        boolean result = showFieldDao.update(showField);
        return result;
    }

    @Override
    public ShowFieldDTO getById(int id) {
        ShowField showField = showFieldDao.getById(id);
        if(showField == null) {
            return null;
        }
        ShowFieldDTO ShowFieldDTO = (ShowFieldDTO) copyObject(showField, ShowFieldDTO.class);
        return ShowFieldDTO;
    }

}
