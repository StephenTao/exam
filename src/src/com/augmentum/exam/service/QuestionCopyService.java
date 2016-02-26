package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.QuestionCopyDTO;

public interface QuestionCopyService {

    int add(QuestionCopyDTO questionCopyDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(QuestionCopyDTO questionCopyDTO) throws ValidationException;

    QuestionCopyDTO getById(int id);

}
