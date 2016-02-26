package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.ExamDao;
import com.augmentum.exam.dto.ExamDTO;
import com.augmentum.exam.model.Exam;
import com.augmentum.exam.service.ExamService;

@Service("examService")
public class ExamServiceImpl extends BaseService implements ExamService {

    @Resource
    private ExamDao examDao;

    @Override
    public ExamDTO getById(int id) {
        Exam exam = examDao.getById(id);
        if (exam == null) {
            return null;
        }
        ExamDTO examDTO = (ExamDTO) copyObject(exam, ExamDTO.class);
        examDTO.setStartTime(exam.getStartTime());
        examDTO.setEndTime(exam.getEndTime());
        return examDTO;
    }

    @Override
    public int add(ExamDTO examDTO) throws ValidationException {
        validateObject(examDTO);
        Exam exam = (Exam) copyObject(examDTO, Exam.class);
        exam.setStartTime(examDTO.getStartTime());
        exam.setEndTime(examDTO.getEndTime());
        examDao.add(exam);
        return exam.getId();
    }

    @Override
    public boolean delete(int id) {
        return examDao.delete(id);
    }

    @Override
    public boolean update(ExamDTO examDTO) throws ValidationException {
        validateObject(examDTO);
        if (examDTO == null || examDTO.getId() <= 0) {
            return false;
        }
        Exam exam = (Exam) copyObject(examDTO, Exam.class);
        exam.setStartTime(examDTO.getStartTime());
        exam.setEndTime(examDTO.getEndTime());
        return examDao.update(exam);
    }
}
