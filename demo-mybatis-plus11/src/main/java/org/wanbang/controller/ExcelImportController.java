package org.wanbang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.wanbang.service.ExcelImportService;

@RestController
@RequestMapping("/import")
public class ExcelImportController {

    @Autowired
    private ExcelImportService excelImportService;

    @PostMapping("/excel")
    public ResponseEntity<String> importExcel(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("请上传文件");
        }

        try {
            long start = System.currentTimeMillis();
            int total = excelImportService.importLargeExcel(file);
            long time = (System.currentTimeMillis() - start) / 1000;

            return ResponseEntity.ok(String.format("导入成功，共%d条数据，耗时%d秒", total, time));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("导入失败: " + e.getMessage());
        }
    }
}
