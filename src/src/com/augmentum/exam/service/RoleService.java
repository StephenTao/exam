package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.RoleDTO;

public interface RoleService {

    int add(RoleDTO role) throws ValidationException;

    boolean delete(int id);

    boolean update(RoleDTO role) throws ValidationException;

    RoleDTO getById(int id);

    RoleDTO getByCode(String code);

}
