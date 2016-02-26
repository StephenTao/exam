package com.augmentum.exam.service.local;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.augmentum.common.util.SpringUtil;
import com.augmentum.exam.Constants;
import com.augmentum.exam.EContext;
import com.augmentum.exam.base.BaseService;
import com.augmentum.exam.dao.UserRoleDao;
import com.augmentum.exam.model.Role;
import com.augmentum.exam.service.ACLService;

@Service("aclService")
public class ACLServiceImpl extends BaseService implements ACLService {

    private static final String BEAN_NAME_PRIVILEGE_MAP = "privilegesMap";
    private static final String OPEN_PRIVILEGE = "openPrivileges";
    private Map<String, String> privilegesMap;

    @Resource
    private UserRoleDao userRoleDao;

    @PostConstruct
    @SuppressWarnings("unchecked")
    public void init() {
        privilegesMap = (Map<String, String>) SpringUtil.getBean(BEAN_NAME_PRIVILEGE_MAP);
    }

    @Override
    public boolean isAllow(int userId, String privilegeKey) {
        if (isOpenPrivileges(privilegeKey)) {
            return true;
        }
        if (userId <= 0) {
            return false;
        }
        String[] isAllowRoleCode = getRolePriviligeMap(privilegeKey);
        if (isAllowRoleCode == null) {
            return false;
        }

        List<Role> userRole;
        int loginUserId = EContext.getContext().getUserId();
        if (loginUserId == userId) {
            userRole = EContext.getContext().findCurrentUserRoles();
        } else {
            userRole = userRoleDao.getByUserId(userId);
        }
        for (Role role : userRole) {
            for (String allowCode : isAllowRoleCode) {
                if (allowCode.equals(role.getCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isOpenPrivileges(String privilegeKey) {
        @SuppressWarnings("unchecked")
        List<String> openPrivileges = (List<String>) SpringUtil.getBean(OPEN_PRIVILEGE);
        if (openPrivileges != null && openPrivileges.size() > 0) {
            return openPrivileges.contains(privilegeKey);
        }
        return false;
    }

    private String[] getRolePriviligeMap(String privilegeKey) {
        String roleCodes = privilegesMap.get(privilegeKey);
        if (roleCodes.isEmpty()) {
            return null;
        }
        String[] roleCodeArray = roleCodes.split(Constants.SPLIT_COMMA);
        return roleCodeArray;
    }
}
