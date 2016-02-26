package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.QuestionDTO;

public interface QuestionService {

    int add(QuestionDTO questionDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(QuestionDTO questionDTO) throws ValidationException;

    QuestionDTO getById(int id);
}
