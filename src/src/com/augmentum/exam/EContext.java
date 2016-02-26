package com.augmentum.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import com.augmentum.common.AppConstants;
import com.augmentum.exam.dto.UserDTO;
import com.augmentum.exam.model.Role;

public class EContext {

    private static final ThreadLocal<EContext> appContext = new ThreadLocal<EContext>();
    private final HashMap<String, Object> values = new HashMap<String, Object>();

    public static EContext getContext() {
        EContext context = appContext.get();
        if (context == null) {
            context = new EContext();
            appContext.set(context);
        }
        return context;
    }

    public void clear() {
        EContext context = appContext.get();
        if (context != null) {
            context.values.clear();
        }
        context = null;
    }

    public void addObject(String key, Object value) {
        values.put(key, value);
    }

    public Object getObject(String key) {
        return values.get(key);
    }

    public String getUserName() {
        UserDTO userDTO = getUser();
        if (userDTO == null) {
            return "";
        }
        return userDTO.getName();
    }

    public List<Role> findCurrentUserRoles() {
        @SuppressWarnings("unchecked")
        List<Role> currentRole = (List<Role>) values.get(AppConstants.CURRENT_ROLE_CODE);
        return currentRole;
    }

    public Integer getUserId() {
        UserDTO userDTO = getUser();
        if (userDTO == null) {
            return 0;
        }
        return userDTO.getId();
    }

    public UserDTO getUser() {
        UserDTO userDTO = (UserDTO) values.get(AppConstants.USER);
        return userDTO;
    }

    public Locale getLocale() {
        String locale = (String) values.get(AppConstants.LOCALE);
        if (AppConstants.LOCALE_EN_US.equals(locale)) {
            return Locale.US;
        } else {
            return Locale.CHINA;
        }
    }
}
