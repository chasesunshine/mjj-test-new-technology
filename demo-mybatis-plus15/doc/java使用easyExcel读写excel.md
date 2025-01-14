# javaʹ��easyExcel��дexcel
https://gitcode.csdn.net/65aa453eb8e5f01e1e45027c.html?dp_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6NTkyMDY1LCJleHAiOjE3MzI2MDMwMzQsImlhdCI6MTczMTk5ODIzNCwidXNlcm5hbWUiOiJjaGFzZXN1bnNoaW5lIn0._pNsAhVq9xvnb59OwJQ1D9dJ8uprx5RtOGiNiSDU3oA&spm=1001.2101.3001.6650.15&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Eactivity-15-111505745-blog-135001946.235%5Ev43%5Epc_blog_bottom_relevance_base9&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Eactivity-15-111505745-blog-135001946.235%5Ev43%5Epc_blog_bottom_relevance_base9&utm_relevant_index=25
## ���ȵ�һ�����ȵ���EasyExcel��Jar��
        <dependency>
        ����<groupId>com.alibaba</groupId>
        ����<artifactId>easyexcel</artifactId>
        ����<version>2.2.4</version>
        </dependency>

        <!--xls-->
        <dependency>
        ����<groupId>org.apache.poi</groupId>
        ����<artifactId>poi</artifactId>
        ����<version>3.17</version>
        </dependency>
        <dependency>
        ����<groupId>org.apache.poi</groupId>
        ����<artifactId>poi-ooxml</artifactId>
        ����<version>3.17</version>
        </dependency>

## ���ݶ���д��
    �������Ǹ��ݶ�����Excel����������Ҫ����һ������
        @Data
        public class User {

            @ExcelProperty("����")
            private String name;

            @ExcelProperty("�Ա�")
            private String sex;

            @ExcelProperty("����")
            private Integer age;

            @ExcelProperty("���֤")
            private String cardid;
        }

## ʹ��@ExcelPropertyע����ָ����������
        @SpringBootTest
        class Tests {

         @Test
         public void test() {
              // ����Excel·��
              String fileName = "C:\\Users\\likun\\Desktop\\����.xlsx";
              EasyExcel.write(fileName, User.class).sheet("ģ��").doWrite(data());
            }

            private List<User> data() {
                List<User> userList = new ArrayList<>();
                User user;
                for (int i = 1; i <= 10; i++) {
                    user = new User();
                    user.setName("����" + i);
                    user.setSex("��");
                    user.setAge(i);
                    user.setCardid("440582xxxx");
                    userList.add(user);
                }
                return userList;
            }
        }

## �����ֶ�
    �������������Щ�ֶ����ǲ����뵼����Excel�У�ֻҪʹ��@ExcelIgnoreע��Ϳ����ˣ�
        /*
         ��������ֶ�
        */
        @ExcelIgnore
        private String filed;

## д��ָ������
    ��������뵼�����ݵ�ָ�������и���������أ�
        @Data
        public class User {

            @ExcelProperty(value = "����", index = 0)
            private String name;

            @ExcelProperty(value = "�Ա�", index = 1)
            private String sex;

            @ExcelProperty(value = "����", index = 2)
            private Integer age;

            @ExcelProperty(value = "���֤", index = 4)
            private String cardid;
        }


# @ExcelProperty��ȡexcel�е�����
    @ExcelProperty��ȡexcel�е�����
    ʹ��EasyExcel������ȡExcel���ݿ���ͨ�����²���ʵ�֣�
    1. ���EasyExcel��������Ŀ�С�
    2. ����һ��ʵ������ӳ��Excel���С�
    3. ʹ��@ExcelPropertyע����ָ���е����ƺ�˳��
    4. ʹ��EasyExcel�ṩ��API��ȡExcel���ݡ�
    ������һ���򵥵�ʾ�����룺
        import com.alibaba.excel.EasyExcel;
        import com.alibaba.excel.annotation.ExcelProperty;
        import java.util.List;

        // ʵ����ӳ��Excel��
        public class DataModel {
            @ExcelProperty(index = 0)
            private String column1;

            @ExcelProperty(index = 1)
            private String column2;

            // ʡ��getter��setter����
        }

        public class ExcelReaderExample {
            public static void main(String[] args) {
                String fileName = "example.xlsx"; // Excel�ļ�·��
                List<DataModel> dataList = EasyExcel.read(fileName)
                    .head(DataModel.class)
                    .sheet()
                    .doReadSync();

                // �����ȡ��������
                for (DataModel data : dataList) {
                    System.out.println(data.getColumn1() + ", " + data.getColumn2());
                }
            }
        }
        ȷ��example.xlsx�ļ���������Ŀ����ӦĿ¼�£������ļ��ĵ�һ�����е�ͷ����
        ������DataModel����ֶ�ͨ��@ExcelPropertyע����Excel�ж�Ӧ��index���Ա�ʾ�е�˳��EasyExcel.read()�������ڶ�ȡ�ļ���
        ��ͨ��.head(DataModel.class)ָ��ͷ��ӳ���ʵ���ࡣ���.sheet()��ȡ��һ��sheet��.doReadSync()ͬ����ȡ���ݡ�