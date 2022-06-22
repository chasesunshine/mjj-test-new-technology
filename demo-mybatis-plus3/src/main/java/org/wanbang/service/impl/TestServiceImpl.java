package org.wanbang.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.wanbang.common.constant.Constant;
import org.wanbang.common.dto.CoursePriceImportResp;
import org.wanbang.common.dto.TestExcelImportResp;
import org.wanbang.common.entity.Result;
import org.wanbang.service.TestService;

import java.io.IOException;
import java.io.InputStream;
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
