package org.wanbang.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.alibaba.schedulerx.shade.org.h2.schema.Constant;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.wanbang.common.dto.GoodsHasImgModel;
import org.wanbang.common.entity.Result;
import org.wanbang.entity.SpringWorld;
import org.wanbang.service.TestService;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
        String s1 = "13:58";
        String s2 = "13:59";
        Boolean value ;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:ss");
        try {
            Date parse1 = sdf.parse(s1);
            Date parse2 = sdf.parse(s2);

            int i = parse2.compareTo(parse1);
            if(i > 0 ){
                value = true;
            }else {
                value =  false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            value =  false;
        }

        String s = "2";
        System.out.println(value);
    }
}
