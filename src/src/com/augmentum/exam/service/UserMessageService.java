package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.UserMessageDTO;

public interface UserMessageService {

    public UserMessageDTO getById(int id);

    public int add(UserMessageDTO userMessageDTO) throws ValidationException;

    public boolean delete(int id);

    public boolean update(UserMessageDTO userMessageDTO) throws ValidationException;
}
