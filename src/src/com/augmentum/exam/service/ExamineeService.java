package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.ExamineeDTO;

public interface ExamineeService {

    ExamineeDTO getById(int id);

    int add(ExamineeDTO examineeDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(ExamineeDTO examineeDTO) throws ValidationException;

}
