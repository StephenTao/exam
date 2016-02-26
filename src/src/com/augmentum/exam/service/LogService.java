package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.LogDTO;

public interface LogService {

    LogDTO getById(int id);

    int add(LogDTO logDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(LogDTO logDTO) throws ValidationException;

}
