package com.augmentum.common.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.context.ApplicationContext;

import com.augmentum.common.block.BlockAbstract;
import com.augmentum.common.util.SpringUtil;

public class BlockTaglib extends TagSupport {

    private String name;
    private static final long serialVersionUID = 8552823376285213978L;

    @Override
    public int doStartTag() throws JspTagException {
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspTagException {
        ApplicationContext ctx = SpringUtil.getApplicationContext();
        BlockAbstract block = (BlockAbstract)ctx.getBean(name);
        String content = block.displayBlock(pageContext);
        JspWriter out = pageContext.getOut();
        try {
            out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    @Override
    public void release() {
        super.release();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}