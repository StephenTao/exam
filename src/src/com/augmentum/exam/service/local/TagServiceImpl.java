package com.augmentum.exam.service.local;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.TagDao;
import com.augmentum.exam.dto.TagDTO;
import com.augmentum.exam.model.Tag;
import com.augmentum.exam.service.TagService;

@Service("tagService")
public class TagServiceImpl extends BaseService implements TagService {

    @Resource
    private TagDao tagDao;

    @Override
    public TagDTO getById(int id) {
        Tag tag = tagDao.getById(id);
        TagDTO tagDTO = (TagDTO) copyObject(tag, TagDTO.class);
        return tagDTO;
    }

    @Override
    public int add(TagDTO tagDTO) throws ValidationException {
        validateObject(tagDTO);
        Tag tag = (Tag) copyObject(tagDTO, Tag.class);
        tagDao.add(tag);
        return tag.getId();
    }

    @SuppressWarnings("unchecked")
    public List<TagDTO> findListByName(String name) {
        return (List<TagDTO>) copyObject(tagDao.findByName(name), TagDTO.class);
    }
    @Override
    public boolean delete(int id) {
        return tagDao.delete(id);
    }

    @Override
    public boolean update(TagDTO tagDTO) throws ValidationException {
        if (tagDTO == null || tagDTO.getId() <= 0) {
            return false;
        }
        validateObject(tagDTO);
        Tag tag = (Tag) copyObject(tagDTO, Tag.class);
        return tagDao.update(tag);
    }

    @Override
    public List<TagDTO> findAll() {
        List<Tag> tags = tagDao.findAll();
        @SuppressWarnings("unchecked")
        List<TagDTO> tagDTOs = (List<TagDTO>) copyObject(tags, TagDTO.class);
        return tagDTOs;
    }
}
