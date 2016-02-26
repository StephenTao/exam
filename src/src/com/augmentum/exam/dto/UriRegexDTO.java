package com.augmentum.exam.dto;

import java.util.List;
import java.util.Map;

public class UriRegexDTO {

    private List<String> cssFiles;
    private List<Map<String, String>> jsFiles;

    public List<String> getCssFiles() {
        return this.cssFiles;
    }

    public void setCssFiles(List<String> cssFiles) {
        this.cssFiles = cssFiles;
    }

    public List<Map<String, String>> getJsFiles() {
        return this.jsFiles;
    }

    public void setJsFiles(List<Map<String, String>> jsFiles) {
        this.jsFiles = jsFiles;
    }

}
