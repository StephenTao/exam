package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.ResourceDTO;

public interface ResourceService {

    ResourceDTO getById(int id);

    int add(ResourceDTO resourceDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(ResourceDTO resourceDTO) throws ValidationException;

}
