package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.QuestionCommentDao;
import com.augmentum.exam.dto.QuestionCommentDTO;
import com.augmentum.exam.model.QuestionComment;
import com.augmentum.exam.service.QuestionCommentService;

@Service("questionCommentService")
public class QuestionCommentServiceImpl extends BaseService implements QuestionCommentService {

    @Resource
    private QuestionCommentDao questionCommentDao;

    @Override
    public int add(QuestionCommentDTO questionCommentDTO) throws ValidationException {
        validateObject(questionCommentDTO);
        QuestionComment questionComment = (QuestionComment) copyObject(questionCommentDTO, QuestionComment.class);
        questionCommentDao.add(questionComment);
        return questionComment.getId();
    }

    @Override
    public boolean delete(int id) {
        return questionCommentDao.delete(id);
    }

    @Override
    public boolean update(QuestionCommentDTO questionCommentDTO) throws ValidationException {
        if (questionCommentDTO == null || questionCommentDTO.getId() <= 0) {
            return false;
        }
        validateObject(questionCommentDTO);
        QuestionComment questionComment = (QuestionComment) copyObject(questionCommentDTO, QuestionComment.class);
        return questionCommentDao.update(questionComment);
    }

    @Override
    public QuestionCommentDTO getById(int id) {
        QuestionComment comment = questionCommentDao.getById(id);
        if (comment == null) {
            return null;
        }
        QuestionCommentDTO commentDTO = (QuestionCommentDTO) copyObject(comment, QuestionCommentDTO.class);
        commentDTO.setCreatedTime(comment.getCreatedTime());
        return commentDTO;
    }

}
