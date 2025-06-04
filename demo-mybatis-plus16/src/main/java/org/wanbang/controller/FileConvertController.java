package org.wanbang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.wanbang.util.fileconvert.FileToJpgConverter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("fileConvert")
public class FileConvertController {
    @Resource
    private FileToJpgConverter fileToJpgConverter;

    @PostMapping("/file/convert")
    public void test(HttpServletRequest request, HttpServletResponse response){
        try {
            fileToJpgConverter.doPost(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @PostMapping("/file")
    public void importExcel(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        fileToJpgConverter.convertFile(file,response);
    }
}
