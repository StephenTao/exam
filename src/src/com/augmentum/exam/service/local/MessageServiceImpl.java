package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.MessageDao;
import com.augmentum.exam.dto.MessageDTO;
import com.augmentum.exam.model.Message;
import com.augmentum.exam.service.MessageService;

@Service("messageService")
public class MessageServiceImpl extends BaseService implements MessageService {

    @Resource
    private MessageDao messageDao;

    @Override
    public MessageDTO getById(int id) {
        Message message = messageDao.getById(id);
        if (message == null) {
            return null;
        }
        MessageDTO messageDTO = (MessageDTO) copyObject(message, MessageDTO.class);
        messageDTO.setCreatedTime(message.getCreatedTime());
        return messageDTO;
    }

    @Override
    public int add(MessageDTO messageDTO) throws ValidationException {
        validateObject(messageDTO);
        Message message = (Message) copyObject(messageDTO, Message.class);
        messageDao.add(message);
        return message.getId();
    }

    @Override
    public boolean delete(int id) {
        return messageDao.delete(id);
    }

    @Override
    public boolean update(MessageDTO messageDTO) throws ValidationException {
        validateObject(messageDTO);
        if (messageDTO == null || messageDTO.getId() <= 0) {
            return false;
        }
        Message message = (Message) copyObject(messageDTO, Message.class);
        return messageDao.update(message);
    }
}
