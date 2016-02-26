package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.PaperQuestionDao;
import com.augmentum.exam.dto.PaperQuestionDTO;
import com.augmentum.exam.model.PaperQuestion;
import com.augmentum.exam.service.PaperQuestionService;

@Service("paperQuestionService")
public class PaperQuestionServiceImpl extends BaseService implements PaperQuestionService {

    @Resource
    private PaperQuestionDao paperQuestionDao;

    @Override
    public int add(PaperQuestionDTO paperQuestionDTO) throws ValidationException {
        validateObject(paperQuestionDTO);
        PaperQuestion paperQuestion = (PaperQuestion) copyObject(paperQuestionDTO, PaperQuestion.class);
        paperQuestionDao.add(paperQuestion);
        return paperQuestion.getId();
    }

    @Override
    public boolean delete(int id) {
        return paperQuestionDao.delete(id);
    }

    @Override
    public boolean update(PaperQuestionDTO paperQuestionDTO) throws ValidationException {
        if (paperQuestionDTO == null || paperQuestionDTO.getId() <= 0) {
            return false;
        }
        validateObject(paperQuestionDTO);
        PaperQuestion paperQuestion = (PaperQuestion) copyObject(paperQuestionDTO, PaperQuestion.class);
        paperQuestion.setCreatedTime(paperQuestionDTO.getCreatedTime());
        return paperQuestionDao.update(paperQuestion);
    }

    @Override
    public PaperQuestionDTO getById(int id) {
        PaperQuestion paperQuestion = paperQuestionDao.getById(id);
        if (paperQuestion == null) {
            return null;
        }
        PaperQuestionDTO paperQuestionDTO = (PaperQuestionDTO) copyObject(paperQuestion, PaperQuestionDTO.class);
        paperQuestionDTO.setCreatedTime(paperQuestion.getCreatedTime());
        return paperQuestionDTO;
    }

}
