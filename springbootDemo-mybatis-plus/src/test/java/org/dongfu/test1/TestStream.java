package org.dongfu.test1;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.dongfu.entity.common.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestStream {

    @Test
    public void testGroupby(){
        Product prod1 = new Product(1L, 1, new BigDecimal("15.5"), "面包", "零食");
        Product prod2 = new Product(2L, 2, new BigDecimal("20"), "饼干", "零食");
        Product prod3 = new Product(3L, 3, new BigDecimal("30"), "月饼", "零食");
        Product prod4 = new Product(4L, 3, new BigDecimal("10"), "青岛啤酒", "啤酒");
        Product prod5 = new Product(5L, 10, new BigDecimal("15"), "百威啤酒", "啤酒");
        List<Product> prodList = Lists.newArrayList(prod1, prod2, prod3, prod4, prod5);

//        Map<String, List<Product>> prodMap= prodList.stream().collect(Collectors.groupingBy(Product::getCategory,Collectors.toList()));
//        System.out.println(JSON.toJSONString(prodMap));

        Map<String, List<Product>> prodMap= prodList.stream().collect(Collectors.groupingBy(item -> {
            if(item.getNum() < 3) {
                return "3";
            }else {
                return "other";
            }
        }));

        System.out.println(JSON.toJSONString(prodMap));
    }
}
