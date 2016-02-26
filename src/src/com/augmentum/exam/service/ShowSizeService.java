package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.ShowSizeDTO;

public interface ShowSizeService {

    int add(ShowSizeDTO showSizeDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(ShowSizeDTO showSizeDTO) throws ValidationException;

    ShowSizeDTO getById(int id);

}
