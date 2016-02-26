package com.augmentum.exam.service.local;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.Constants;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.QuestionDao;
import com.augmentum.exam.dao.QuestionOptionDao;
import com.augmentum.exam.dao.QuestionTagDao;
import com.augmentum.exam.dao.TagDao;
import com.augmentum.exam.dto.QuestionDTO;
import com.augmentum.exam.dto.QuestionOptionDTO;
import com.augmentum.exam.dto.TagDTO;
import com.augmentum.exam.model.Question;
import com.augmentum.exam.model.QuestionOption;
import com.augmentum.exam.model.QuestionTag;
import com.augmentum.exam.model.Tag;
import com.augmentum.exam.service.QuestionService;

@Service("questionService")
public class QuestionServiceImpl extends BaseService implements QuestionService {

    @Resource
    private QuestionDao questionDao;
    @Resource
    private QuestionOptionDao questionOptionDao;
    @Resource
    private QuestionTagDao questionTagDao;
    @Resource
    private TagDao tagDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(QuestionDTO questionDTO) throws ValidationException {
        questionDTO.setTitleText(questionDTO.getTitle());
        questionDTO.setCode(getRandomCode());
        int id = 0;
        if (questionDTO.getQuestionTypeId() == 1) {
            validateObject(questionDTO);
            String answer = questionDTO.getAnswer();
            if (answer == null || answer.isEmpty()) {
                ValidationException ex = new ValidationException();
                ex.addError(Constants.QUESTION_ANSWER, Constants.QUESTION_ANSWER_CONTENT);
                throw ex;
            } else {
                Question question = (Question) copyObject(questionDTO, Question.class);
                questionDao.addQuestion(question);
            }
        } else if (questionDTO.getQuestionTypeId() == 2) {
            validateObject(questionDTO);
            Question question = (Question) copyObject(questionDTO, Question.class);
            questionDao.addQuestion(question);
            id = question.getId();
            int num = 1;
            List<QuestionOptionDTO> optionList = questionDTO.getOptions();
            if (optionList == null || optionList.isEmpty()) {
                ValidationException ex = new ValidationException();
                ex.addError(Constants.QUESTION_OPTION, Constants.QUESTION_OPTION_CONTENT);
                throw ex;
            } else {
                for (QuestionOptionDTO option : optionList) {
                    option.setQuestionId(id);
                    option.setTitleText(option.getTitle());
                    option.setOrder(num);
                    num++;
                    validateObject(option);
                    QuestionOption questionOption = (QuestionOption) copyObject(option, QuestionOption.class);
                    questionOptionDao.add(questionOption);
                }
            }
        }
        List<TagDTO> tagList = questionDTO.getTags();
        if (tagList == null || tagList.isEmpty()) {
            ValidationException ex = new ValidationException();
            ex.addError(Constants.TAG, Constants.TAG_CONTENT);
            throw ex;
        } else {
            for (TagDTO tagDTO : tagList) {
                validateObject(tagDTO);
                if (tagDTO.getId() > 0) {
                    QuestionTag questionTag = new QuestionTag();
                    questionTag.setQuestionId(id);
                    questionTag.setTagId(tagDTO.getId());
                    questionTagDao.add(questionTag);
                } else {
                    Tag tag = (Tag) copyObject(tagDTO, Tag.class);
                    tagDao.add(tag);
                }
            }
        }
        return id;
    }

    @Override
    public boolean delete(int id) {
        return questionOptionDao.deleteByQuestionId(id) && questionDao.delete(id);
    }

    @Override
    public boolean update(QuestionDTO questionDTO) throws ValidationException {
        if (questionDTO == null || questionDTO.getId() <= 0) {
            return false;
        }
        validateObject(questionDTO);
        Question question = (Question) copyObject(questionDTO, Question.class);
        question.setUpdatedTime(new Date());
        questionDao.update(question);
        if (questionDTO.getOptions() == null || questionDTO.getOptions().isEmpty()) {
            return Boolean.TRUE;
        }
        for (QuestionOptionDTO option : questionDTO.getOptions()) {
            validateObject(option);
            QuestionOption questionOption = (QuestionOption) copyObject(option, QuestionOption.class);
            questionOptionDao.update(questionOption);
        }
        return Boolean.TRUE;
    }

    @Override
    public QuestionDTO getById(int id) {
        Question question = questionDao.getById(id);
        if (question == null) {
            return null;
        }
        QuestionDTO questionDTO = (QuestionDTO) copyObject(question, QuestionDTO.class);
        questionDTO.setCreatedTime(question.getCreatedTime());
        questionDTO.setUpdatedTime(question.getUpdatedTime());
        List<QuestionOption> options = questionOptionDao.findByQuestionId(id);
        @SuppressWarnings("unchecked")
        List<QuestionOptionDTO> optionDTOs = (List<QuestionOptionDTO>) copyObject(options, QuestionOptionDTO.class);
        questionDTO.setOptions(optionDTOs);
        return questionDTO;
    }
}
