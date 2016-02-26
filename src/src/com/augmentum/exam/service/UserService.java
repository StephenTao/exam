package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.UserDTO;

public interface UserService {

    int add(UserDTO userDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(UserDTO userDTO) throws ValidationException;

    UserDTO getById(int id);

    UserDTO getUserByName(String userName);

}
