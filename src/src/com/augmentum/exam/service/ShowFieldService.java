package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.ShowFieldDTO;

public interface ShowFieldService {

    int add(ShowFieldDTO showFieldDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(ShowFieldDTO showFieldDTO) throws ValidationException;

    ShowFieldDTO getById(int id);
}
