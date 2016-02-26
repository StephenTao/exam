package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.MessageHistoryDTO;

public interface MessageHistoryService {

    MessageHistoryDTO getById(int id);

    int add(MessageHistoryDTO messageHistoryDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(MessageHistoryDTO messageHistoryDTO) throws ValidationException;

}
