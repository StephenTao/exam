package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.PaperDTO;

public interface PaperService {

    int add(PaperDTO paperDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(PaperDTO paperDTO) throws ValidationException;

    PaperDTO getById(int id);

}
