package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.LogDao;
import com.augmentum.exam.dto.LogDTO;
import com.augmentum.exam.model.Log;
import com.augmentum.exam.service.LogService;

@Service("logService")
public class LogServiceImpl extends BaseService implements LogService {

    @Resource
    private LogDao logDao;

    @Override
    public LogDTO getById(int id) {
        Log log = logDao.getById(id);
        if(log == null) {
            return null;
        }
        LogDTO LogDTO = (LogDTO) copyObject(log, LogDTO.class);
        LogDTO.setCreatedTime(log.getCreatedTime());
        return LogDTO;
    }

    @Override
    public int add(LogDTO LogDTO) throws ValidationException {
        validateObject(LogDTO);
        Log Log = (Log) copyObject(LogDTO, Log.class);
        logDao.add(Log);
        return Log.getId();
    }

    @Override
    public boolean delete(int id) {
        return logDao.delete(id);
    }

    @Override
    public boolean update(LogDTO LogDTO) throws ValidationException {
        if(LogDTO == null || LogDTO.getId() <= 0) {
            return false;
        }
        validateObject(LogDTO);
        Log Log = (Log) copyObject(LogDTO, Log.class);
        return logDao.update(Log);
    }
}
