package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.LogHistoryDao;
import com.augmentum.exam.dto.LogHistoryDTO;
import com.augmentum.exam.model.LogHistory;
import com.augmentum.exam.service.LogHistoryService;

@Service("logHistoryService")
public class LogHistoryServiceImpl extends BaseService implements LogHistoryService {

    @Resource
    private LogHistoryDao logHistoryDao;

    @Override
    public LogHistoryDTO getById(int id) {
        LogHistory logHistory = logHistoryDao.getById(id);
        if (logHistory == null) {
            return null;
        }
        LogHistoryDTO logHistoryDTO = (LogHistoryDTO) copyObject(logHistory, LogHistoryDTO.class);
        logHistoryDTO.setCreatedTime(logHistory.getCreatedTime());
        return logHistoryDTO;
    }

    @Override
    public int add(LogHistoryDTO logHistoryDTO) throws ValidationException {
        validateObject(logHistoryDTO);
        LogHistory logHistory = (LogHistory) copyObject(logHistoryDTO, LogHistory.class);
        logHistory.setCreatedTime(logHistoryDTO.getCreatedTime());
        logHistoryDao.add(logHistory);
        return logHistory.getId();
    }

    @Override
    public boolean delete(int id) {
        return logHistoryDao.delete(id);
    }

    @Override
    public boolean update(LogHistoryDTO logHistoryDTO) throws ValidationException {
        validateObject(logHistoryDTO);
        if (logHistoryDTO == null || logHistoryDTO.getId() <= 0) {
            return false;
        }
        LogHistory logHistory = (LogHistory) copyObject(logHistoryDTO, LogHistory.class);
        return logHistoryDao.update(logHistory);
    }
}
