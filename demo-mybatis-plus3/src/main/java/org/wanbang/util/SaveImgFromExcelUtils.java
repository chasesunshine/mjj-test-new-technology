package org.wanbang.util;
/**
* @description: TODO
* @author majiajian
* @date 2022/6/22 16:38
* @version 1.0
*/

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class SaveImgFromExcelUtils {

    //最终图片要保存到的目标文件夹
    public static String ImgFolder = "D:\\tmp\\test\\pic\\";

    public static void main(String[] args) throws Exception {
        test("D:\\tmp\\test\\测试excel.xlsx");
    }

    public static String test(String excelPath) throws Exception {
        File file = new File(excelPath);
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        // 打开HSSFWorkbook
        POIFSFileSystem fs = new POIFSFileSystem(in);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        // 1.读出的Excel中的图片信息和位置信息
        Map<String, HSSFPictureData> maplist = null;
        HSSFSheet sheet = wb.getSheetAt(0);
        // 只支持xls版本，
        if (file.getPath().endsWith(".xls")) {
            maplist = getPictures((HSSFSheet) sheet);
//			// 如有需要，可遍历打印map信息
//			for (Map.Entry<String, HSSFPictureData> entry : maplist.entrySet()) {
//				System.out.println(entry.getKey() + ":" + entry.getValue());
//			}
        }
        // 保存图片到指定位置
        printImg(maplist);
        //关流
        wb.close();
        fs.close();
        in.close();
        return "----FINISH----";
    }


    //获取图片信息和所在行号列号，
    //已扩展，还能获取所在行指定列的数据
    private static Map<String, HSSFPictureData> getPictures(HSSFSheet sheet) throws IOException {
        Map<String, HSSFPictureData> map = new HashMap<String, HSSFPictureData>();
        List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
        for (HSSFShape shape : list) {
            if (shape instanceof HSSFPicture) {
                HSSFPicture picture = (HSSFPicture) shape;
                HSSFClientAnchor cAnchor = (HSSFClientAnchor) picture.getAnchor();
                HSSFPictureData pdata = picture.getPictureData();
                // key = 行号-列号
                String key = cAnchor.getRow1() + "-" + cAnchor.getCol1();
//				// 如有需要，还可以获取图片所在行的指定列的单元格内容
//				// 获取行数据
//				HSSFRow hssfRow = sheet.getRow(cAnchor.getRow1());
//				// 获取同行的指定列单元格数据，以下示例读取同行第1列（从0开始）的数据
//				HSSFCell cell = hssfRow.getCell(1);
//				System.out.println("--第" + cAnchor.getRow1() + "行,第" + 1+ "列数据=" + cell.toString());
//				key = key + "|" + cell.toString();
                map.put(key, pdata);
            }
        }
        return map;
    }

    // 图片保存
    public static void printImg(Map<String, HSSFPictureData> maplist) throws IOException {
        Object key[] = maplist.keySet().toArray();
        for (int i = 0; i < maplist.size(); i++) {
            // 获取图片流
            HSSFPictureData pic = maplist.get(key[i]);
            // 获取图片所在行的指定单元格数据
            String picName = key[i].toString();
            byte[] data = pic.getData();
            // 图片保存路径
            FileOutputStream out = new FileOutputStream(ImgFolder + picName + ".jpg");
            out.write(data);
            out.close();
        }
    }
}


