package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.UserMessageDao;
import com.augmentum.exam.dto.UserMessageDTO;
import com.augmentum.exam.model.UserMessage;
import com.augmentum.exam.service.UserMessageService;

@Service("userMessageService")
public class UserMessageServiceImpl extends BaseService implements UserMessageService {

    @Resource
    private UserMessageDao userMessageDao;

    @Override
    public UserMessageDTO getById(int id) {
        UserMessage userMessage = userMessageDao.getById(id);
        if (userMessage == null) {
            return null;
        }
        UserMessageDTO userMessageDTO = (UserMessageDTO) copyObject(userMessage, UserMessageDTO.class);
        userMessageDTO.setReceivedTime(userMessage.getReceivedTime());
        return userMessageDTO;
    }

    @Override
    public int add(UserMessageDTO userMessageDTO) throws ValidationException {
        validateObject(userMessageDTO);
        UserMessage userMessage = (UserMessage) copyObject(userMessageDTO, UserMessage.class);
        userMessageDao.add(userMessage);
        return userMessage.getId();
    }

    @Override
    public boolean delete(int id) {
        return userMessageDao.delete(id);
    }

    @Override
    public boolean update(UserMessageDTO userMessageDTO) throws ValidationException {
        validateObject(userMessageDTO);
        if (userMessageDTO == null || userMessageDTO.getId() <= 0) {
            return false;
        }
        UserMessage userMessage = (UserMessage) copyObject(userMessageDTO, UserMessage.class);
        return userMessageDao.update(userMessage);
    }
}
