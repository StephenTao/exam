package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.PaperPartDao;
import com.augmentum.exam.dto.PaperPartDTO;
import com.augmentum.exam.model.PaperPart;
import com.augmentum.exam.service.PaperPartService;

@Service("paperPartService")
public class PaperPartServiceImpl extends BaseService implements PaperPartService {

    @Resource
    private PaperPartDao paperPartDao;

    @Override
    public int add(PaperPartDTO paperPartDTO) throws ValidationException {
        validateObject(paperPartDTO);
        PaperPart paperPart = (PaperPart) copyObject(paperPartDTO, PaperPart.class);
        paperPartDao.add(paperPart);
        return paperPart.getId();
    }

    @Override
    public boolean delete(int id) {
        return paperPartDao.delete(id);
    }

    @Override
    public boolean update(PaperPartDTO paperPartDTO) throws ValidationException {
        if(paperPartDTO == null || paperPartDTO.getId() <= 0) {
            return false;
        }
        validateObject(paperPartDTO);
        PaperPart paperPart = (PaperPart) copyObject(paperPartDTO, PaperPart.class);
        return paperPartDao.update(paperPart);
    }

    @Override
    public PaperPartDTO getById(int id) {
        PaperPart paperPart = paperPartDao.getById(id);
        if(paperPart == null) {
            return null;
        }
        PaperPartDTO paperPartDTO = (PaperPartDTO) copyObject(paperPart, PaperPartDTO.class);
        return paperPartDTO;
    }

}
