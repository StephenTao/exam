package com.augmentum.exam.service.local;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.exception.ValidationException;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.RoleDao;
import com.augmentum.exam.dto.RoleDTO;
import com.augmentum.exam.model.Role;
import com.augmentum.exam.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseService implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public int add(RoleDTO roleDTO) throws ValidationException {
        validateObject(roleDTO);
        Role roles = (Role) copyObject(roleDTO, Role.class);
        roleDao.add(roles);
        return roles.getId();
    }

    @Override
    public boolean delete(int id) {
        return roleDao.delete(id);
    }

    @Override
    public boolean update(RoleDTO roleDTO) throws ValidationException {
        if(roleDTO == null || roleDTO.getId() <= 0) {
            return false;
        }
        validateObject(roleDTO);
        Role role = (Role) copyObject(roleDTO, Role.class);
        return roleDao.update(role);
    }

    @Override
    public RoleDTO getById(int id) {
        Role role = roleDao.getById(id);
        if(role == null) {
            return null;
        }
        RoleDTO roleDTO = (RoleDTO) copyObject(role, RoleDTO.class);
        return roleDTO;
    }

    @Override
    public RoleDTO getByCode(String code) {
        Role role = roleDao.getByCode(code);
        if(role == null) {
            return null;
        }
        RoleDTO roleDTO = (RoleDTO) copyObject(role, RoleDTO.class);
        return roleDTO;
    }

}
