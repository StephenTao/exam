package com.augmentum.common.block;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.apache.log4j.Logger;

import com.augmentum.common.AppConstants;
import com.augmentum.common.dto.PaginationDTO;
import com.augmentum.exam.EContext;

public abstract class BlockAbstract {
    protected static final String BLOCK_TEMPLATE = "BLOCK_TEMPLATE";
    public String template;
    private static Logger log = Logger.getLogger(BlockAbstract.class);

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String displayBlock(PageContext pageContext) {
        execute(pageContext);
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String blockTemplate = (String) request.getAttribute(BLOCK_TEMPLATE);
        Writer body = new StringWriter();
        try {
            if (blockTemplate != null && !blockTemplate.trim().equals("")) {

                pageContext.pushBody(body);
                pageContext.include(blockTemplate);
                pageContext.popBody();

                return body.toString();
            }
            if (blockTemplate != null && blockTemplate.trim().equals("")) {
                return "";
            }
            if (template != null && !template.trim().equals("")) {
                pageContext.pushBody(body);
                pageContext.include(template);
                pageContext.popBody();

                return body.toString();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                body.close();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
                e.printStackTrace();
            }
        }
        return "";
    }

    abstract protected void execute(PageContext pageContext);

    protected void pagination(Integer currentPage, String relativeUrl, HttpServletRequest request,
            PaginationCallBack<?> paginationCallBack) {
        paginationCallBack.run(currentPage, null, relativeUrl, request);
    }

    protected void pagination(Integer currentPage, Integer pageSize, String relativeUrl, HttpServletRequest request,
            PaginationCallBack<?> paginationCallBack) {
        paginationCallBack.run(currentPage, pageSize, relativeUrl, request);
    }

    protected abstract class PaginationCallBack<T> {

        public void run(Integer currentPage, Integer pageSize, String relativeUrl, HttpServletRequest request) {
            PaginationDTO<T> paginationDTO = new PaginationDTO<T>();
            EContext.getContext().addObject(AppConstants.PAGINATION_DTO, paginationDTO);
            paginationDTO.setCurrentPage(currentPage);
            if (pageSize != null) {
                paginationDTO.setPageSize(pageSize);
            }
            paginationDTO.setRelativeUrl(relativeUrl);
            List<T> itemList = callBack();
            paginationDTO.setItemList(itemList);
            request.setAttribute(AppConstants.PAGINATION_DTO, paginationDTO);
        }

        abstract public List<T> callBack();

    }

}
