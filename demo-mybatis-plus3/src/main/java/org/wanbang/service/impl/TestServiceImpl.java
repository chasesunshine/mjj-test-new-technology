package org.wanbang.service.impl;

import ch.qos.logback.core.util.FileUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.wanbang.common.constant.Constant;
import org.wanbang.common.dto.CoursePriceImportResp;
import org.wanbang.common.dto.TestExcelImportResp;
import org.wanbang.common.entity.Result;
import org.wanbang.service.TestService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Override
    public Result importFile(MultipartFile file) {
        List<TestExcelImportResp> coursePriceImportRespAll = new ArrayList<>();

        String fileName = file.getOriginalFilename();
        Result res = checkExcelFile(file, fileName);

        if (res != null) {
            return res;
        }

        try {
            Workbook hssfWorkbook = getWorkBook(file);
            //获取sheet数量
            int sheetNum = hssfWorkbook.getNumberOfSheets();
            final ImportParams importParams = new ImportParams();
            // 第一行表头，从第二行开始读取
            importParams.setHeadRows(Constant.NUM_1);
            // 校验Excel文件，去掉空行
            importParams.setNeedVerify(true);

            for (int sheetIndex = 0; sheetIndex < sheetNum; sheetIndex++){
                //第几个sheet页
                importParams.setStartSheetIndex(sheetIndex);
                InputStream inputStream = file.getInputStream();
                List<TestExcelImportResp> coursePriceImportResp = ExcelImportUtil.importExcel(inputStream, TestExcelImportResp.class, importParams);

                coursePriceImportRespAll.addAll(coursePriceImportResp);
            }
        } catch (Exception e) {
            log.error("excel转换错", e);
            return Result.error(e.getMessage());
        }


        log.info("过滤无效值");
//        List<CoursePriceImportResp> coursePriceImportResps = coursePriceImportRespAll.stream()
//                .filter(
//                        coursePriceImportResp -> !StringUtils.isEmpty(coursePriceImportResp.getCourseId())
//                ).filter(
//                        coursePriceImportResp -> !StringUtils.isEmpty(coursePriceImportResp.getPrice())
//                ).collect(Collectors.toList());
//
//        if (CollectionUtils.isEmpty(coursePriceImportResps)) {
//            return Result.error("excel未导入数据 或 表中未填写数据");
//        }


        return null;
    }

    @Override
    public Result importFile1(MultipartFile multipartFile) throws IOException {

        File file = multipartFileToFile(multipartFile);

        // 文件路径可以根据自己需求来 我的是放在本地根路径下了
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(file);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        int numberOfSheets = wb.getNumberOfSheets();

        XSSFSheet sheet = wb.getSheetAt(0);
        List<POIXMLDocumentPart> list = sheet.getRelations();
        for (POIXMLDocumentPart part : list) {
            if (part instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) part;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    XSSFPicture picture = (XSSFPicture) shape;
                    PictureData pic = picture.getPictureData();
                    XSSFClientAnchor anchor = picture.getPreferredSize();
                    CTMarker marker = anchor.getFrom();
                    // 获取图片格式
                    String ext = pic.suggestFileExtension();

                    byte[] data = pic.getData();
                    log.info("行号[{}],单元格[{}],图片格式[{}]", marker.getRow(), marker.getCol(), ext);
                }
            }
        }


        return null;
    }

    private File multipartFileToFile(MultipartFile file) throws IOException {
        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }
    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除本地临时文件
     * @param file
     */
    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }


    public static Workbook getWorkBook(MultipartFile file) throws IOException {
        //这样写excel能兼容03和07
        InputStream is = file.getInputStream();
        Workbook hssfWorkbook = null;
        try {
            hssfWorkbook = new HSSFWorkbook(is);
        } catch (Exception ex) {
            is =file.getInputStream();
            hssfWorkbook = new XSSFWorkbook(is);
        }
        return hssfWorkbook;
    }

    private Result checkExcelFile(MultipartFile file, String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            log.info("企业培训价格 没有导入文件");
            return Result.error("企业培训价格 没有导入文件");
        }
        if (file.getSize() > Constant.NUM_1024 * Constant.NUM_1024 * Constant.NUM_10) {
            log.info("upload | 上传失败: 文件大小超过10M，文件大小为：{}", file.getSize());
            return Result.error("上传失败: 文件大小不能超过10M!");
        }
        if (fileName.lastIndexOf(Constant.POINT) != -1 && !Constant.EXCEL_SUFFIX.equals(fileName.substring(fileName.lastIndexOf(Constant.POINT)))) {
            log.error("文件名格式不正确, 请使用后缀名为.XLSX的文件");
            return Result.error("文件名格式不正确, 请使用后缀名为.XLSX的文件");
        }
        return null;
    }
}
