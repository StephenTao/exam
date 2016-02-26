package com.augmentum.exam.service;

import java.util.List;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.QuestionTypeDTO;

public interface QuestionTypeService {

    int add(QuestionTypeDTO questionTypeDTO) throws ValidationException;

    boolean update(QuestionTypeDTO questionTypeDTO) throws ValidationException;

    boolean delete(int id);

    QuestionTypeDTO getById(int id);

    List<QuestionTypeDTO> findAll();

}
