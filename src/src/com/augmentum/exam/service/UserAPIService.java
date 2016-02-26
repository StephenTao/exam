package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.UserAPIDTO;

public interface UserAPIService {

    UserAPIDTO getById(int id);

    int add(UserAPIDTO userAPIDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(UserAPIDTO userAPIDTO) throws ValidationException;
}
