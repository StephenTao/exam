package com.augmentum.exam.service.local;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.ExamineeAnswerDao;
import com.augmentum.exam.dto.ExamineeAnswerDTO;
import com.augmentum.exam.model.ExamineeAnswer;
import com.augmentum.exam.service.ExamineeAnswerService;

@Service("examineeAnswerService")
public class ExamineeAnswerServiceImpl extends BaseService implements ExamineeAnswerService {

    @Resource
    private ExamineeAnswerDao examineeAnswerDao;

    @Override
    public boolean add(ExamineeAnswerDTO examineeAnswerDTO) throws ValidationException {
        validateObject(examineeAnswerDTO);
        ExamineeAnswer examineeAnswer = (ExamineeAnswer) copyObject(examineeAnswerDTO, ExamineeAnswer.class);
        boolean result = examineeAnswerDao.add(examineeAnswer);
        return result;
    }

    @Override
    public boolean update(ExamineeAnswerDTO examineeAnswerDTO) throws ValidationException {
        if(examineeAnswerDTO == null || examineeAnswerDTO.getExamineeId() <= 0 || examineeAnswerDTO.getPaperQuestionId() <= 0) {
            return false;
        }
        validateObject(examineeAnswerDTO);
        ExamineeAnswer examineeAnswer = (ExamineeAnswer) copyObject(examineeAnswerDTO, ExamineeAnswer.class);
        boolean result = examineeAnswerDao.update(examineeAnswer);
        return result;
    }

    @Override
    public ExamineeAnswerDTO getByIds(int examineeId, int questionId) {
        ExamineeAnswer examineeAnswer = examineeAnswerDao.getByIds(examineeId, questionId);
        if(examineeAnswer == null) {
            return null;
        }
        ExamineeAnswerDTO examineeAnswerDTO = (ExamineeAnswerDTO) copyObject(examineeAnswer, ExamineeAnswerDTO.class);
        return examineeAnswerDTO;
    }

}
