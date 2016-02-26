package com.augmentum.exam.cache;

import java.util.Map;

import com.augmentum.exam.dto.UriRegexDTO;

public class UriRegexCache {

    private static Map<String, UriRegexDTO> uriRegexs;

    public static Map<String, UriRegexDTO> getUriRegexs() {
        return uriRegexs;
    }

    public void setUriRegexs(Map<String, UriRegexDTO> uriRegexs) {
        UriRegexCache.uriRegexs = uriRegexs;
    }

}
