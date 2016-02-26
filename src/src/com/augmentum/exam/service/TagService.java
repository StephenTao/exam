package com.augmentum.exam.service;

import java.util.List;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.dto.TagDTO;

public interface TagService {

    TagDTO getById(int id);

    int add(TagDTO tagDTO) throws ValidationException;

    boolean delete(int id);

    boolean update(TagDTO tagDTO) throws ValidationException;

    List<TagDTO> findAll();

    List<TagDTO> findListByName(String name);
}
