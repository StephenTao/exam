package com.augmentum.exam.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.augmentum.exam.Constants;
import com.augmentum.exam.base.BaseController;

@Controller("i18nController")
@RequestMapping("/i18n")
public class I18nController extends BaseController {
    @RequestMapping(value = "/switch", method = RequestMethod.GET)
    public void language(@RequestParam("locale") String locale) {
        @SuppressWarnings("unused")
        Locale currentLocale = Locale.getDefault();
        if (Constants.LANGUAGE_EN_US.equals(locale)) {
            currentLocale = Locale.US;
        } else if (Constants.LANGUAGE_ZH_CN.equals(locale)) {
            currentLocale = Locale.SIMPLIFIED_CHINESE;
        }
    }
}
