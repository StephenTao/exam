package com.augmentum.exam.base;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.localization.message.ResourceBundleMessageResolver;

import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.stereotype.Service;

import com.augmentum.common.conveter.DateConvert;
import com.augmentum.common.exception.ValidationException;
import com.augmentum.common.util.ObjectUtil;
import com.augmentum.exam.Constants;
import com.augmentum.exam.EContext;

@Service("baseService")
public abstract class BaseService {

    private static final String OVAL_MESSAGE_BASE_NAME = "ovalMessage";
    private static final ResourceBundle RESOURCE_BUNDLE_ZH_CN = ResourceBundle.getBundle(
            OVAL_MESSAGE_BASE_NAME, Locale.CHINA);
    private static final ResourceBundle RESOURCE_BUNDLE_EN_US = ResourceBundle.getBundle(
            OVAL_MESSAGE_BASE_NAME, Locale.US);

    static {
        ConvertUtils.register(new DateConvert(), Date.class);
    }

    protected Object copyObject(Object srcObject,Class<?> clz) {
        return ObjectUtil.objectCopy(srcObject, clz);
    }

    @Resource
    protected Validator validator;

    protected boolean validateObject(Object o) throws ValidationException {
        ResourceBundleMessageResolver resolver = (ResourceBundleMessageResolver) Validator
                .getMessageResolver();
        ResourceBundle resourceBundle = getResourceBundle();
        resolver.addMessageBundle(resourceBundle);

        List<ConstraintViolation> violations = validator.validate(o);
        if (violations != null && !violations.isEmpty()) {
            ValidationException validationException = new ValidationException();
            for (ConstraintViolation violation : violations) {
                String ovalField = violation.getContext().toString();
                String fieldNameTemp = ovalField.substring(0, ovalField.lastIndexOf("."));
                Integer index = fieldNameTemp.lastIndexOf(".");
                String fieldName = ovalField.substring(index + 1, ovalField.length());
                String message = violation.getMessage();
                // get field display name
                fieldName = resourceBundle.getString(fieldName);
                message = message.replace(ovalField, fieldName);
                validationException.addError(fieldName, message);

            }
            if (validationException.isError()) {
                throw validationException;
            }
        }

        return true;
    }

    private ResourceBundle getResourceBundle() {
        Locale locale = EContext.getContext().getLocale();
        if (locale == Locale.US) {
            return RESOURCE_BUNDLE_EN_US;
        } else {
            return RESOURCE_BUNDLE_ZH_CN;
        }
    }

    public String getRandomCode() {
        String digitStr = String.valueOf(Math.random() * Math.pow(System.currentTimeMillis(), 1.0 / 2));
        return digitStr.substring(digitStr.indexOf('.') + 1);
    }

    public static final String filterDataByRegex(String data) {
        Matcher matcher = Pattern.compile(Constants.REGEX_FILE).matcher(data);
        while (matcher.find()) {
            String source = matcher.group();
            String fileName = source.substring(source.indexOf('#') + 1, source.indexOf(']'));
            if (source.matches(Constants.REGEX_IMG)) {
                data = data.replaceAll(Constants.REGEX_IMG, "<img src='" + fileName + "'/>");
            } else if (source.matches(Constants.REGEX_AUDIO)) {
                data = data.replaceAll(Constants.REGEX_AUDIO, "<a href='" + fileName + "'><img src='" + fileName
                        + "'/></a>");
            } else if (source.matches(Constants.REGEX_VIDEO)) {
                data = data.replaceAll(Constants.REGEX_VIDEO, "<a href='" + fileName + "'><img src='" + fileName
                        + "'/></a>");
            }
        }
        return data;
    }
}
