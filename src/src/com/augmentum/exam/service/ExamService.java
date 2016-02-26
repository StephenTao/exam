package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.ExamDTO;

public interface ExamService {

    ExamDTO getById(int id);

    int add(ExamDTO examDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(ExamDTO examDTO) throws ValidationException;

}
