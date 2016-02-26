package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.APIDao;
import com.augmentum.exam.dto.APIDTO;
import com.augmentum.exam.model.API;
import com.augmentum.exam.service.APIService;

@Service("apiService")
public class APIServiceImpl extends BaseService implements APIService {

    @Resource
    private APIDao apiDao;

    @Override
    public APIDTO getById(int id) {
        API api = apiDao.getById(id);
        APIDTO apiDTO = (APIDTO) copyObject(api, APIDTO.class);
        return apiDTO;
    }

    @Override
    public int add(APIDTO apiDTO) throws ValidationException {
        validateObject(apiDTO);
        API api = (API) copyObject(apiDTO, API.class);
        apiDao.add(api);
        return api.getId();
    }

    @Override
    public boolean delete(int id) {
        return apiDao.delete(id);
    }

    @Override
    public boolean update(APIDTO apiDTO) throws ValidationException {
        validateObject(apiDTO);
        if (apiDTO == null || apiDTO.getId() <= 0) {
            return false;
        }
        API api = (API) copyObject(apiDTO, API.class);
        return apiDao.update(api);
    }
}
