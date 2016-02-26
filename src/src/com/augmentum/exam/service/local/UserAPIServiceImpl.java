package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.UserAPIDao;
import com.augmentum.exam.dto.UserAPIDTO;
import com.augmentum.exam.model.UserAPI;
import com.augmentum.exam.service.UserAPIService;

@Service("userAPIService")
public class UserAPIServiceImpl extends BaseService implements UserAPIService {

    @Resource
    private UserAPIDao userAPIDao;

    @Override
    public UserAPIDTO getById(int id) {
        UserAPI userAPI = userAPIDao.getById(id);
        if (userAPI == null) {
            return null;
        }
        UserAPIDTO userApiDTO = (UserAPIDTO) copyObject(userAPI, UserAPIDTO.class);
        userApiDTO.setCreatedTime(userAPI.getCreatedTime());
        return userApiDTO;
    }

    @Override
    public int add(UserAPIDTO userApiDTO) throws ValidationException {
        validateObject(userApiDTO);
        UserAPI userApi = (UserAPI) copyObject(userApiDTO, UserAPI.class);
        userAPIDao.add(userApi);
        return userApi.getId();
    }

    @Override
    public boolean delete(int id) {
        return userAPIDao.delete(id);
    }

    @Override
    public boolean update(UserAPIDTO userApiDTO) throws ValidationException {
        validateObject(userApiDTO);
        if (userApiDTO == null || userApiDTO.getId() <= 0) {
            return false;
        }
        UserAPI userApi = (UserAPI) copyObject(userApiDTO, UserAPI.class);
        return userAPIDao.update(userApi);
    }
}
