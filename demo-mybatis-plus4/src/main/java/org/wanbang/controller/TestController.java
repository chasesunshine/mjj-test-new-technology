package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.entity.TestUser1;

import javax.validation.Valid;
import java.util.*;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/27 11:06
* @version 1.0
*/
@RestController
@RequestMapping("/test")
public class TestController {

    //2)全局捕获异常
    @RequestMapping("/test-error")
    public String testError(int a) {
        int b = 1/a;
        return "success"+b;

    }

    //2)全局捕获异常
    @RequestMapping("/test-error1")
    public String testError1(@RequestBody @Valid TestUser1 testUser1) {
        return "success" + 1;
    }


//    public static void main(String[] args) {
//        List<String> listAll= new ArrayList<>();
//
//        List<String> list1= new ArrayList<>();
//        List<String> list2= new ArrayList<>();
//
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//
//        listAll.addAll(list1);
//
//        list2.add("4");
//        list2.add("5");
//        list2.add("6");
//
//        listAll.addAll(list2);
//
//        System.out.println(JSON.toJSONString(listAll));
//    }

//    public static void main(String[] args) {
//        Map<Integer, Long> map = new HashMap<>();
//        map.put(0, 0L);
//        map.put(1, 1L);
//
//        String a = JSON.toJSONString(map);
//
//        map = JSON.parseObject(a, Map.class);
//        Long b = map.get(1);
//    }

    public static void main(String[] args) {
//        String s = "123,xxx,wwww";
//        String[] split = s.split(",");
//        String[] split1 = s.split(split[0]+",");
//        System.out.println(split[0] + " - " + split1[1]);

        String s = "[1872, 1873, 1874, 1875, 1876, 1877, 1878, 1879, 1882, 1883, 1884, 1885, 1886, 1887, 1889, 2030, 1061, 1062, 1063, 1064, 1066, 1067, 1068, 1069, 1070, 1071, 1072, 1074, 1899, 2046, 2059, 2068, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 342, 343, 344, 345, 346, 3368, 3402, 3470, 347, 348, 349, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 372, 373, 374, 375, 376, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 2514, 388, 389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, 404, 405, 407, 408, 409, 410, 3401, 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 430, 431, 432, 433, 434, 435, 436, 437, 3468, 438, 439, 440, 441, 442, 443, 444, 445, 446, 447, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463, 464, 3414, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476, 477, 478, 479, 480, 481, 482, 483, 485, 486, 488, 489, 2309, 2310, 2755, 3400, 2215, 2276, 2277, 2278, 2279, 2731, 2732, 2733, 2734, 2736, 2737]";
        s.replace("[","").replace("]","").replace(" ","");
        List<String> oldStreetIdList = Arrays.asList(s.split(","));

        System.out.println(oldStreetIdList.size());
    }
}
