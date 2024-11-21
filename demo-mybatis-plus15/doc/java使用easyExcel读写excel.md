# java使用easyExcel读写excel
https://gitcode.csdn.net/65aa453eb8e5f01e1e45027c.html?dp_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6NTkyMDY1LCJleHAiOjE3MzI2MDMwMzQsImlhdCI6MTczMTk5ODIzNCwidXNlcm5hbWUiOiJjaGFzZXN1bnNoaW5lIn0._pNsAhVq9xvnb59OwJQ1D9dJ8uprx5RtOGiNiSDU3oA&spm=1001.2101.3001.6650.15&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Eactivity-15-111505745-blog-135001946.235%5Ev43%5Epc_blog_bottom_relevance_base9&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Eactivity-15-111505745-blog-135001946.235%5Ev43%5Epc_blog_bottom_relevance_base9&utm_relevant_index=25
## 首先第一步得先导入EasyExcel的Jar包
        <dependency>
        　　<groupId>com.alibaba</groupId>
        　　<artifactId>easyexcel</artifactId>
        　　<version>2.2.4</version>
        </dependency>

        <!--xls-->
        <dependency>
        　　<groupId>org.apache.poi</groupId>
        　　<artifactId>poi</artifactId>
        　　<version>3.17</version>
        </dependency>
        <dependency>
        　　<groupId>org.apache.poi</groupId>
        　　<artifactId>poi-ooxml</artifactId>
        　　<version>3.17</version>
        </dependency>

## 根据对象写入
    接下来是根据对象导入Excel，首先我们要定义一个对象：
        @Data
        public class User {

            @ExcelProperty("姓名")
            private String name;

            @ExcelProperty("性别")
            private String sex;

            @ExcelProperty("年龄")
            private Integer age;

            @ExcelProperty("身份证")
            private String cardid;
        }

## 使用@ExcelProperty注解来指定标题名称
        @SpringBootTest
        class Tests {

         @Test
         public void test() {
              // 生成Excel路径
              String fileName = "C:\\Users\\likun\\Desktop\\测试.xlsx";
              EasyExcel.write(fileName, User.class).sheet("模板").doWrite(data());
            }

            private List<User> data() {
                List<User> userList = new ArrayList<>();
                User user;
                for (int i = 1; i <= 10; i++) {
                    user = new User();
                    user.setName("张三" + i);
                    user.setSex("男");
                    user.setAge(i);
                    user.setCardid("440582xxxx");
                    userList.add(user);
                }
                return userList;
            }
        }

## 忽略字段
    如果对象里面有些字段我们并不想导出到Excel中，只要使用@ExcelIgnore注解就可以了：
        /*
         忽略这个字段
        */
        @ExcelIgnore
        private String filed;

## 写入指定的列
    如果我们想导出数据到指定的列中该如何设置呢？
        @Data
        public class User {

            @ExcelProperty(value = "姓名", index = 0)
            private String name;

            @ExcelProperty(value = "性别", index = 1)
            private String sex;

            @ExcelProperty(value = "年龄", index = 2)
            private Integer age;

            @ExcelProperty(value = "身份证", index = 4)
            private String cardid;
        }


# @ExcelProperty读取excel中的数据
    @ExcelProperty读取excel中的数据
    使用EasyExcel库来读取Excel数据可以通过以下步骤实现：
    1. 添加EasyExcel依赖到项目中。
    2. 创建一个实体类来映射Excel的列。
    3. 使用@ExcelProperty注解来指定列的名称和顺序。
    4. 使用EasyExcel提供的API读取Excel数据。
    以下是一个简单的示例代码：
        import com.alibaba.excel.EasyExcel;
        import com.alibaba.excel.annotation.ExcelProperty;
        import java.util.List;

        // 实体类映射Excel列
        public class DataModel {
            @ExcelProperty(index = 0)
            private String column1;

            @ExcelProperty(index = 1)
            private String column2;

            // 省略getter和setter方法
        }

        public class ExcelReaderExample {
            public static void main(String[] args) {
                String fileName = "example.xlsx"; // Excel文件路径
                List<DataModel> dataList = EasyExcel.read(fileName)
                    .head(DataModel.class)
                    .sheet()
                    .doReadSync();

                // 处理读取到的数据
                for (DataModel data : dataList) {
                    System.out.println(data.getColumn1() + ", " + data.getColumn2());
                }
            }
        }
        确保example.xlsx文件存在于项目的相应目录下，并且文件的第一行是列的头部。
        代码中DataModel类的字段通过@ExcelProperty注解与Excel列对应，index属性表示列的顺序。EasyExcel.read()方法用于读取文件，
        并通过.head(DataModel.class)指定头部映射的实体类。最后，.sheet()读取第一个sheet，.doReadSync()同步读取数据。