package com.augmentum.exam.service.local;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.QuestionTypeDao;
import com.augmentum.exam.dto.QuestionTypeDTO;
import com.augmentum.exam.model.QuestionType;
import com.augmentum.exam.service.QuestionTypeService;

@Service("questionTypeService")
public class QuestionTypeServiceImpl extends BaseService implements QuestionTypeService {

    @Resource
    private QuestionTypeDao questionTypeDao;

    @Override
    public int add(QuestionTypeDTO questionTypeDTO) throws ValidationException {
        validateObject(questionTypeDTO);
        QuestionType questionType = (QuestionType) copyObject(questionTypeDTO, QuestionType.class);
        questionTypeDao.add(questionType);
        return questionType.getId();
    }

    @Override
    public boolean update(QuestionTypeDTO questionTypeDTO) throws ValidationException {
        if (questionTypeDTO == null || questionTypeDTO.getId() <= 0) {
            return false;
        }
        validateObject(questionTypeDTO);
        QuestionType questionType = (QuestionType) copyObject(questionTypeDTO, QuestionType.class);
        return questionTypeDao.update(questionType);
    }

    @Override
    public boolean delete(int id) {
        return questionTypeDao.delete(id);
    }

    @Override
    public QuestionTypeDTO getById(int id) {
        QuestionType type = questionTypeDao.getById(id);
        QuestionTypeDTO typeDTO = (QuestionTypeDTO) copyObject(type, QuestionTypeDTO.class);
        return typeDTO;
    }

    @Override
    public List<QuestionTypeDTO> findAll() {
        List<QuestionType> types = questionTypeDao.findAll();
        @SuppressWarnings("unchecked")
        List<QuestionTypeDTO> typeDTOs = (List<QuestionTypeDTO>) copyObject(types, QuestionTypeDTO.class);
        return typeDTOs;
    }

}
