package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.PaperQuestionDTO;

public interface PaperQuestionService {

    int add(PaperQuestionDTO paperQuestionDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(PaperQuestionDTO paperQuestionDTO) throws ValidationException;

    PaperQuestionDTO getById(int id);

}
