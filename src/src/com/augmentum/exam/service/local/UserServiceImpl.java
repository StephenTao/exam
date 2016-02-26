package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.UserDao;
import com.augmentum.exam.dto.UserDTO;
import com.augmentum.exam.model.User;
import com.augmentum.exam.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public int add(UserDTO userDTO) throws ValidationException {
        validateObject(userDTO);
        User user = (User) copyObject(userDTO, User.class);
        userDao.add(user);
        return user.getId();
    }

    @Override
    public boolean delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public boolean update(UserDTO userDTO) throws ValidationException {
        if(userDTO == null || userDTO.getId() <= 0) {
            return false;
        }
        validateObject(userDTO);
        User user = (User) copyObject(userDTO, User.class);
        return userDao.update(user);
    }

    @Override
    public UserDTO getById(int id) {
        User user = userDao.getById(id);
        if(user == null) {
            return null;
        }
        UserDTO userDTO = (UserDTO) copyObject(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public UserDTO getUserByName(String name) {
        User user = userDao.getByName(name);
        UserDTO userDTO = (UserDTO) copyObject(user, UserDTO.class);
        return userDTO;
    }
}
