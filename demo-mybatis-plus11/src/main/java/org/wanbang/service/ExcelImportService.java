package org.wanbang.service;

import org.springframework.web.multipart.MultipartFile;

public interface ExcelImportService {

    public int importLargeExcel(MultipartFile file) throws Exception;
}
