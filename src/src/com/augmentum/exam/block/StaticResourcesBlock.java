package com.augmentum.exam.block;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.augmentum.common.AppConstants;
import com.augmentum.common.block.BlockAbstract;
import com.augmentum.exam.EContext;
import com.augmentum.exam.cache.UriRegexCache;
import com.augmentum.exam.dto.UriRegexDTO;

public class StaticResourcesBlock extends BlockAbstract {

    private static final String CSS_FILES = "cssFiles";

    private static final String JS_FILES = "jsFiles";

    @Override
    protected void execute(PageContext pageContext) {

        HttpServletRequest httpServletRequest = (HttpServletRequest) pageContext.getRequest();
        String requestedUri = (String) EContext.getContext().getObject(AppConstants.REQUESTED_URI);

        List<String> cssFiles = null;
        List<Map<String, String>> jsFiles = null;
        Map<String, UriRegexDTO> uriRegexs = UriRegexCache.getUriRegexs();
        Set<Entry<String, UriRegexDTO>> entrys = uriRegexs.entrySet();
        for (Entry<String, UriRegexDTO> entry : entrys) {
            if (requestedUri.matches(entry.getKey())) {
                UriRegexDTO uriRegexDTO = entry.getValue();
                cssFiles = uriRegexDTO.getCssFiles();
                jsFiles = uriRegexDTO.getJsFiles();
                break;
            }
        }
        httpServletRequest.setAttribute(CSS_FILES, cssFiles);
        httpServletRequest.setAttribute(JS_FILES, jsFiles);
    }

}
