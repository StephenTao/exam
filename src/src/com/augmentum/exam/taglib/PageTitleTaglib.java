package com.augmentum.exam.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.augmentum.common.util.SpringUtil;
import com.augmentum.exam.Constants;
import com.augmentum.exam.EContext;

public class PageTitleTaglib extends TagSupport {

    private static final long serialVersionUID = 5491483715554516514L;

    private final Logger log = Logger.getLogger(PageTitleTaglib.class);

    @Override
    public int doStartTag() throws JspTagException {
        String titleKey = (String) EContext.getContext().getObject(Constants.PAGE_TITLE);

        JspWriter out = pageContext.getOut();
        try {
            out.println(SpringUtil.getMessage(titleKey));
        } catch (IOException e) {
            log.error(Constants.LOG_ERROR, e);
        }
        return EVAL_PAGE;
    }

    @Override
    public int doEndTag() throws JspTagException {
        return SKIP_BODY;
    }
}
