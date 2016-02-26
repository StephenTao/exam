package com.augmentum.common.util;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class ObjectUtil {

    @SuppressWarnings("unchecked")
    public static Object objectCopy(Object srcObject, Class<?> targetClass) {
        Object targetObject = null;
        if ((srcObject == null) || (targetClass == null)) {
            return null;
        }
        if (srcObject instanceof Collection) {
            @SuppressWarnings("rawtypes")
            Iterator iter = ((Collection) srcObject).iterator();
            @SuppressWarnings("rawtypes")
            Collection coll = new ArrayList();
            Object item = null;
            Object targetItem = null;
            while (iter.hasNext()) {
                item = iter.next();
                targetItem = _objectCopy(item, targetClass);
                coll.add(targetItem);
            }
            targetObject = coll;
        } else {
            targetObject = _objectCopy(srcObject, targetClass);
        }
        return targetObject;
    }

    private static Object _objectCopy(Object srcObject, Class<?> targetClass) {
        Object targetObject = null;
        try {
            targetObject = targetClass.newInstance();
            BeanUtil.copyProperties(targetObject, srcObject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return targetObject;
    }

}

class BeanUtil extends BeanUtils {

    private BeanUtil() {
    }

    static {
        ConvertUtils.register(new DateConvert(), java.util.Date.class);
        ConvertUtils.register(new DateConvert(), java.sql.Date.class);
    }

    public static void copyProperties(Object target, Object source) throws InvocationTargetException,
            IllegalAccessException {
        BeanUtils.copyProperties(target, source);

    }
}

class DateConvert implements Converter {

    private static final String DATE_FMT_1 = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FMT_2 = "yyyy-MM-dd";

    @Override
    public Object convert(@SuppressWarnings("rawtypes") Class type, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Date) {
            return value;
        }
        if (value instanceof Long) {
            Long longValue = (Long) value;
            return new Date(longValue.longValue());
        }
        if (value instanceof String) {
            String s = (String) value;
            try {
                SimpleDateFormat df = new SimpleDateFormat(DATE_FMT_1);
                return df.parse(s.trim());
            } catch (Exception e) {
                try {
                    SimpleDateFormat df = new SimpleDateFormat(DATE_FMT_2);
                    return df.parse(s.trim());
                } catch (ParseException ex) {
                    return null;
                }
            }
        }
        return null;
    }
}
