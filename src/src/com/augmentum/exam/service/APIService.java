package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.APIDTO;

public interface APIService {

    APIDTO getById(int id);

    int add(APIDTO apiDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(APIDTO apiDTO) throws ValidationException;

}
