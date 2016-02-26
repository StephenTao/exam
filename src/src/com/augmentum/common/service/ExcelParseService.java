package com.augmentum.common.service;

import java.io.File;
import java.util.Map;

/**
 * Import excel interface
 */
public interface ExcelParseService {

    Map<String, Object> importExcel(File file, Map<String, Object> param) throws Exception;

}
