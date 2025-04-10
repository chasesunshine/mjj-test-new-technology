package org.wanbang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.wanbang.dto.req.DownloadDataReq;
import org.wanbang.dto.req.UploadDataReq;
import org.wanbang.util.HadoopUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/hadoop/files")
public class HadoopController {
    @Autowired
    private HadoopUtil hadoopUtil;
    /**
     * 服务器地址
     */
    @Value("${hadoop.fsUri}")
    private String fsUri;

    /**
     * 上传路径
     */
    @Value("${hadoop.input.path}")
    private String inputPath;

    /**
     * 上传本地文件
     *
     * @param uploadDataReq 上传的文件
     * @return
     * @throws Exception
     */
    @PostMapping("/uploadLocal")
    public String uploadlocal(@RequestBody UploadDataReq uploadDataReq) throws Exception {
        //上传时需要补全文件名
        String uploadUrl = fsUri+inputPath+"xx.csv";
        // "srcFile": "C://Users//daikin//Desktop//工作记录//GPF Cloud式样书清单整理.xlsx"
        hadoopUtil.uploadLocalFileToHDFS(uploadDataReq.getSrcFile(), uploadUrl);
        return "upload";
    }

    /**
     * 下载文件
     *
     * @param downloadDataReq hadoop上的文件名称
     * @param response
     */
    @PostMapping("/download")
    public void downloadFile(@RequestBody DownloadDataReq downloadDataReq, HttpServletResponse response) {
        //下载文件名及路径
        // "srcFile": "xx.csv"
        String hdfsFilePath=fsUri+inputPath+"/"+downloadDataReq.getSrcFile();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + hdfsFilePath.substring(hdfsFilePath.lastIndexOf('/') + 1));
        try {
            hadoopUtil.downloadFileFromHDFS(hdfsFilePath, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }


}

