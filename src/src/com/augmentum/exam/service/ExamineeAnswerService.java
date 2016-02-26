package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.ExamineeAnswerDTO;

public interface ExamineeAnswerService {

    boolean add(ExamineeAnswerDTO examineeAnswerDTO) throws ValidationException;

    boolean update(ExamineeAnswerDTO examineeAnswerDTO) throws ValidationException;

    ExamineeAnswerDTO getByIds(int examineeId, int questionId);
}
