package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.LogHistoryDTO;

public interface LogHistoryService {

    LogHistoryDTO getById(int id);

    int add(LogHistoryDTO logHistoryDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(LogHistoryDTO logHistoryDTO) throws ValidationException;

}
