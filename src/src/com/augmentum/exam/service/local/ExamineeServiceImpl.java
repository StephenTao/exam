package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.ExamineeDao;
import com.augmentum.exam.dto.ExamineeDTO;
import com.augmentum.exam.model.Examinee;
import com.augmentum.exam.service.ExamineeService;

@Service("examineeService")
public class ExamineeServiceImpl extends BaseService implements ExamineeService {

    @Resource
    private ExamineeDao examineeDao;

    @Override
    public ExamineeDTO getById(int id) {
        Examinee examinee = examineeDao.getById(id);
        if(examinee == null) {
            return null;
        }
        ExamineeDTO examineeDTO = (ExamineeDTO) copyObject(examinee, ExamineeDTO.class);
        examineeDTO.setAttendedTime(examinee.getAttendedTime());
        return examineeDTO;
    }

    @Override
    public int add(ExamineeDTO examineeDTO) throws ValidationException {
        validateObject(examineeDTO);
        Examinee examinee = (Examinee) copyObject(examineeDTO, Examinee.class);
        examineeDao.add(examinee);
        return examinee.getId();
    }

    @Override
    public boolean delete(int id) {
        return examineeDao.delete(id);
    }

    @Override
    public boolean update(ExamineeDTO examineeDTO) throws ValidationException {
        if(examineeDTO == null || examineeDTO.getId() <= 0) {
            return false;
        }
        validateObject(examineeDTO);
        Examinee examinee = (Examinee) copyObject(examineeDTO, Examinee.class);
        examinee.setAttendedTime(examineeDTO.getAttendedTime());
        boolean result = examineeDao.update(examinee);
        return result;
    }

}
