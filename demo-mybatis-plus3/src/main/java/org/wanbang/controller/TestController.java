package org.wanbang.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.alibaba.schedulerx.shade.org.h2.schema.Constant;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.wanbang.common.dto.GoodsHasImgModel;
import org.wanbang.common.entity.Result;
import org.wanbang.entity.SpringWorld;
import org.wanbang.service.TestService;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/6/22 16:14
 * @version 1.0
 */

@Component
@RestController
@RequestMapping("/rpc")
public class TestController {
    @Resource
    private TestService testService;

    /**
     * 批量导入 企业培训价格
     *
     * @param file
     * @return
     */
    @PostMapping("/import/file")
    public Result importFile(@RequestParam(value = "file", required = false) MultipartFile file) {
        return testService.importFile(file);
    }

    /**
     * 批量导入 企业培训价格
     *
     * @param file
     * @return
     */
    @PostMapping("/import/file1")
    public Result importFile1(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        return testService.importFile1(file);
    }

//    public static void main(String[] args) {
////        Short a = 1;
////        if(!ObjectUtils.isEmpty(a)){
////            boolean b = a == Constant.INDEX;
////            String s = String.valueOf(b);
////            System.out.printf(s);
////
////        }
//
//        HashMap<Integer , SpringWorld> objectObjectHashMap = new HashMap<>();
//        SpringWorld build = SpringWorld.builder().id((long) 1).age(4).build();
//        SpringWorld build1 = SpringWorld.builder().id((long) 2).age(5).build();
//        SpringWorld build2 = SpringWorld.builder().id((long) 3).age(6).build();
//        objectObjectHashMap.put(1,build);
//        objectObjectHashMap.put(2,build1);
//        objectObjectHashMap.put(3,build2);
//
//        SpringWorld springWorld = objectObjectHashMap.get(1);
//        springWorld.setAge(8);
//
//        System.out.printf(objectObjectHashMap.get(1).getAge().toString());
//    }

    public static void main(String[] args) {
//        String s1 = "13:58";
//        String s2 = "13:59";
//        Boolean value ;
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:ss");
//        try {
//            Date parse1 = sdf.parse(s1);
//            Date parse2 = sdf.parse(s2);
//
//            int i = parse2.compareTo(parse1);
//            if(i > 0 ){
//                value = true;
//            }else {
//                value =  false;
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//            value =  false;
//        }
//
//        String s = "2";
//        System.out.println(value);

        String a = "1.2";
        String[] split = a.split("\\.");
        System.out.println(split[0]);
        System.out.println(split[1]);
    }

    @GetMapping("/import/file2")
    public void exportTemplate(HttpServletResponse response) {
        ExcelWriter writer = new ExcelWriter(false, "公司");

        List<String> company = CollUtil.newArrayList("COMPANY_ID", "CITY_CODE", "COMPANY_NAME", "IDENTIFIER", "ADDRESS", "BUSINESS_SCOPE", "CONTACT_ADDRESS","ECONOMIC_TYPE", "REG_CAPITAL","LEGAL_NAME", "LEGAL_ID", "LEGAL_PHONE", "LEGAL_PHOTO");
        List<String> companys = CollUtil.newArrayList("3301HZJS8068", "330100","332529199203140011","18057894789");

        List<List<String>> companyExcel = CollUtil.newArrayList(company, companys);
        writer.write(companyExcel, true);
        writer.autoSizeColumnAll();

        writer.setSheet("车辆");

        List<String> vehicle = CollUtil.newArrayList("VEHICLE_NO", "PLATE_COLOR", "SEATS", "STATE", "FLAG");
        List<String> vehicles = CollUtil.newArrayList("浙A127FB","1","5","0","1");

        List<List<String>> vehicleExcel = CollUtil.newArrayList(vehicle, vehicles);
        writer.write(vehicleExcel, true);
        writer.autoSizeColumnAll();

        writer.setSheet("司机");

        List<String> driver = CollUtil.newArrayList("DRIVER_NAME", "DRIVER_PHONE", "DRIVER_FLAG");
        List<String> drivers =
                CollUtil.newArrayList("王先生", "17516717771","1");

        List<List<String>> driverExcel = CollUtil.newArrayList(driver, drivers);
        writer.write(driverExcel, true);
        writer.autoSizeColumnAll();


        ServletOutputStream out = null;
        String codedFileName;
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            codedFileName = URLEncoder.encode("car-vehicle-driver", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + codedFileName + ".xlsx");
            out = response.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.flush(out, true);
            writer.close();
            IoUtil.close(out);
        }
    }

}
