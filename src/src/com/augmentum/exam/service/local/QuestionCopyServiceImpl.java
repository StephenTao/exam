package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.QuestionCopyDao;
import com.augmentum.exam.dto.QuestionCopyDTO;
import com.augmentum.exam.model.QuestionCopy;
import com.augmentum.exam.service.QuestionCopyService;

@Service("questionCopyService")
public class QuestionCopyServiceImpl extends BaseService implements QuestionCopyService {

    @Resource
    private QuestionCopyDao questionCopyDao;

    @Override
    public int add(QuestionCopyDTO questionCopyDTO) throws ValidationException {
        validateObject(questionCopyDTO);
        QuestionCopy questionCopy = (QuestionCopy) copyObject(questionCopyDTO, QuestionCopy.class);
        questionCopyDao.add(questionCopy);
        return questionCopy.getId();
    }

    @Override
    public boolean delete(int id) {
        return questionCopyDao.delete(id);
    }

    @Override
    public boolean update(QuestionCopyDTO questionCopyDTO) throws ValidationException {
        if(questionCopyDTO == null || questionCopyDTO.getId() <= 0) {
            return false;
        }
        validateObject(questionCopyDTO);
        QuestionCopy questionCopy = (QuestionCopy) copyObject(questionCopyDTO, QuestionCopy.class);
        return questionCopyDao.update(questionCopy);
    }

    @Override
    public QuestionCopyDTO getById(int id) {
        QuestionCopy questionCopy = questionCopyDao.getById(id);
        if(questionCopy == null) {
            return null;
        }
        QuestionCopyDTO questionCopyDTO = (QuestionCopyDTO) copyObject(questionCopy, QuestionCopyDTO.class);
        questionCopyDTO.setCreatedTime(questionCopy.getCreatedTime());
        questionCopyDTO.setUpdatedTime(questionCopy.getUpdatedTime());
        return questionCopyDTO;
    }

}
