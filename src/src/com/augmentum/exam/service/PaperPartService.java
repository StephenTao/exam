package com.augmentum.exam.service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.PaperPartDTO;

public interface PaperPartService {

    int add(PaperPartDTO paperPartDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(PaperPartDTO paperPartDTO) throws ValidationException;

    PaperPartDTO getById(int id);
}
