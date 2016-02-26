package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.MessageDTO;

public interface MessageService {

    MessageDTO getById(int id);

    int add(MessageDTO messageDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(MessageDTO messageDTO) throws ValidationException;

}
