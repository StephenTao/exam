package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.QuestionCommentDTO;

public interface QuestionCommentService {

    int add(QuestionCommentDTO questionCommentDTO) throws ValidationException;

    boolean update(QuestionCommentDTO questionCommentDTO) throws ValidationException;

    boolean delete(int id);

    QuestionCommentDTO getById(int id);

}
