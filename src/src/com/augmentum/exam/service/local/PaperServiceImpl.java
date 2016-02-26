package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.PaperDao;
import com.augmentum.exam.dto.PaperDTO;
import com.augmentum.exam.model.Paper;
import com.augmentum.exam.service.PaperService;

@Service("paperService")
public class PaperServiceImpl extends BaseService implements PaperService {

    @Resource
    private PaperDao paperDao;

    @Override
    public int add(PaperDTO paperDTO) throws ValidationException {
        validateObject(paperDTO);
        Paper paper = (Paper) copyObject(paperDTO, Paper.class);
        paperDao.add(paper);
        return paper.getId();
    }

    @Override
    public boolean delete(int id) {
        return paperDao.delete(id);
    }

    @Override
    public boolean update(PaperDTO paperDTO) throws ValidationException {
        if (paperDTO == null || paperDTO.getId() <= 0) {
            return false;
        }
        validateObject(paperDTO);
        Paper paper = (Paper) copyObject(paperDTO, Paper.class);
        paper.setCreatedTime(paperDTO.getCreatedTime());
        return paperDao.update(paper);
    }

    @Override
    public PaperDTO getById(int id) {
        Paper paper = paperDao.getById(id);
        if (paper == null) {
            return null;
        }
        PaperDTO paperDTO = (PaperDTO) copyObject(paper, PaperDTO.class);
        paperDTO.setCreatedTime(paper.getCreatedTime());
        return paperDTO;
    }

}
