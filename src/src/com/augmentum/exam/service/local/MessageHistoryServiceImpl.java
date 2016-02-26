package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.MessageHistoryDao;
import com.augmentum.exam.dto.MessageHistoryDTO;
import com.augmentum.exam.model.MessageHistory;
import com.augmentum.exam.service.MessageHistoryService;

@Service("messageHistoryService")
public class MessageHistoryServiceImpl extends BaseService implements MessageHistoryService {

    @Resource
    private MessageHistoryDao messageHistoryDao;

    @Override
    public MessageHistoryDTO getById(int id) {
        MessageHistory messageHistory = messageHistoryDao.getById(id);
        if (messageHistory == null) {
            return null;
        }
        MessageHistoryDTO messageHistoryDTO = (MessageHistoryDTO) copyObject(messageHistory, MessageHistoryDTO.class);
        messageHistoryDTO.setCreatedTime(messageHistory.getCreatedTime());
        return messageHistoryDTO;
    }

    @Override
    public int add(MessageHistoryDTO messageHistoryDTO) throws ValidationException {
        validateObject(messageHistoryDTO);
        MessageHistory messageHistory = (MessageHistory) copyObject(messageHistoryDTO, MessageHistory.class);
        messageHistory.setCreatedTime(messageHistoryDTO.getCreatedTime());
        messageHistoryDao.add(messageHistory);
        return messageHistory.getId();
    }

    @Override
    public boolean delete(int id) {
        return messageHistoryDao.delete(id);
    }

    @Override
    public boolean update(MessageHistoryDTO messageHistoryDTO) throws ValidationException {
        validateObject(messageHistoryDTO);
        if (messageHistoryDTO == null || messageHistoryDTO.getId() <= 0) {
            return false;
        }
        MessageHistory messageHistory = (MessageHistory) copyObject(messageHistoryDTO, MessageHistory.class);
        return messageHistoryDao.update(messageHistory);
    }
}
