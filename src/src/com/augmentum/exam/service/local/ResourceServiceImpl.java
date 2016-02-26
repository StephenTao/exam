package com.augmentum.exam.service.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.ResourceDao;
import com.augmentum.exam.dto.ResourceDTO;
import com.augmentum.exam.model.Resource;
import com.augmentum.exam.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl extends BaseService implements ResourceService {

    @Autowired
    @Qualifier("resourceDao")
    private ResourceDao resourceDao;
    @Override
    public ResourceDTO getById(int id) {
        Resource resource = resourceDao.getById(id);
        ResourceDTO resourceDTO = (ResourceDTO) copyObject(resource, ResourceDTO.class);
        return resourceDTO;
    }

    @Override
    public int add(ResourceDTO resourceDTO) throws ValidationException {
        validateObject(resourceDTO);
        Resource resource = (Resource) copyObject(resourceDTO, Resource.class);
        resourceDao.add(resource);
        return resource.getId();
    }

    @Override
    public boolean delete(int id) {
        return resourceDao.delete(id);
    }

    @Override
    public boolean update(ResourceDTO resourceDTO) throws ValidationException {
        validateObject(resourceDTO);
        if (resourceDTO == null || resourceDTO.getId() <= 0) {
            return false;
        }
        Resource resource = (Resource) copyObject(resourceDTO, Resource.class);
        return resourceDao.update(resource);
    }
}
