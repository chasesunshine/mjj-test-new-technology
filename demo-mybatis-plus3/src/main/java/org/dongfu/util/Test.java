package org.dongfu.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
* @description: TODO
* @author majiajian
* @date 2022/6/22 17:22
* @version 1.0
*/

// POI 读取excel图片并定位图片需要提前注意的事项
    // https://blog.csdn.net/hanerer1314/article/details/117386322

@Slf4j
public class Test {
    public static void main(String[] args) {

        // 文件路径可以根据自己需求来 我的是放在本地根路径下了
        File file = new File("D:\\tmp\\test\\测试excel.xlsx");
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(file);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
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

    }

}
