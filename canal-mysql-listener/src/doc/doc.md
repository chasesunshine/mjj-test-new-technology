# sql:
    CREATE TABLE `canal_mysql_listener` (
      `id` bigint(20) NOT NULL COMMENT '主键ID',
      `name` varchar(30) DEFAULT NULL COMMENT '姓名',
      `age` int(11) DEFAULT NULL COMMENT '年龄',
      `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;


# Canal安装和配置，实现监听binlog日志（这篇负责安装 cancal，除了代码其余的都要 跟着做 ）
    https://blog.csdn.net/qq_45932382/article/details/127051444
    启动 ： startup.bat
    
# Canal学习笔记 | 简单Demo获取更新插入和删除的数据 （这篇的代码比较靠谱）
    https://blog.csdn.net/qq_20051535/article/details/113180211?spm=1001.2101.3001.6650.5&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-5-113180211-blog-103732526.235%5Ev29%5Epc_relevant_default_base&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-5-113180211-blog-103732526.235%5Ev29%5Epc_relevant_default_base&utm_relevant_index=5
    # 下面是一个简单Demo能够实时获取数据库中增加删除和修改的数据，配合反射等操作可以实现转化为实例对象。
    package com.qiruipeng.canal;
     
    import com.alibaba.otter.canal.client.CanalConnector;
    import com.alibaba.otter.canal.client.CanalConnectors;
    import com.alibaba.otter.canal.protocol.CanalEntry;
    import com.alibaba.otter.canal.protocol.Message;
    import com.google.protobuf.InvalidProtocolBufferException;
     
    import java.net.InetSocketAddress;
    import java.util.List;
     
    /**
     * @author ruipeng.qi
     **/
    public class CanalClient {
    	//Canal服务地址
    	private static final String SERVER_ADDRESS = "127.0.0.1";
     
    	//Canal Server 服务端口号
    	private static final Integer PORT = 11111;
     
    	//目的地，其实Canal Service内部有一个队列
    	private static final String DESTINATION = "example";
     
    	//用户名和密码，但是目前不支持，只能为空
    	private static final String USERNAME = "";
     
    	//用户名和密码，但是目前不支持，只能为空
    	private static final String PASSWORD= "";
     
    	public static void main(String[] args){
    		CanalConnector canalConnector = CanalConnectors.newSingleConnector(new InetSocketAddress(SERVER_ADDRESS, PORT), DESTINATION, USERNAME, PASSWORD);
    		canalConnector.connect();
    		//订阅所有消息
    		canalConnector.subscribe(".*\\..*");
    		//恢复到之前同步的那个位置
    		canalConnector.rollback();
     
    		for(;;){
    			//获取指定数量的数据，但是不做确认标记，下一次取还会取到这些信息
    			Message message = canalConnector.getWithoutAck(100);
    			//获取消息id
    			long batchId = message.getId();
    			if(batchId != -1){
    				System.out.println("msgId -> " + batchId);
    				printEnity(message.getEntries());
    				//提交确认
    				//canalConnector.ack(batchId);
    				//处理失败，回滚数据
    				//canalConnector.rollback(batchId);
    			}
    		}
    	}
     
    	private static void printEnity(List<CanalEntry.Entry> entries) {
    		for (CanalEntry.Entry entry : entries) {
    			if(entry.getEntryType() != CanalEntry.EntryType.ROWDATA){
    				continue;
    			}
    			try{
    				CanalEntry.RowChange rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
    				for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
    					System.out.println(rowChange.getEventType());
    					switch (rowChange.getEventType()){
    						//如果希望监听多种事件，可以手动增加case
    						case INSERT:
    							String tableName = entry.getHeader().getTableName();
    							//测试users表进行映射处
    							List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
    							System.out.println(afterColumnsList);
    							break;
    						case UPDATE:
    							List<CanalEntry.Column> afterColumnsList2 = rowData.getAfterColumnsList();
    							System.out.println("新插入的数据是：" + afterColumnsList2);
    							break;
    						case DELETE:
    							List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
    							System.out.println("被删除的数据是：" + beforeColumnsList);
    							break;
    						default:
    					}
    				}
    			} catch (InvalidProtocolBufferException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }
    # 输出信息：
        msgId -> 2
        INSERT
        [index: 0
        sqlType: 4
        name: "id"
        isKey: true
        updated: true
        isNull: false
        value: "1"
        mysqlType: "int"
        , index: 1
        sqlType: 12
        name: "nick"
        isKey: false
        updated: true
        isNull: false
        value: "cat"
        mysqlType: "varchar(255)"
        , index: 2
        sqlType: 12
        name: "phone"
        isKey: false
        updated: true
        isNull: false
        value: "13821111"
        mysqlType: "varchar(255)"
        , index: 3
        sqlType: 12
        name: "password"
        isKey: false
        updated: true
        isNull: true
        mysqlType: "varchar(255)"
        , index: 4
        sqlType: 12
        name: "email"
        isKey: false
        updated: true
        isNull: true
        mysqlType: "varchar(255)"
        , index: 5
        sqlType: 12
        name: "account"
        isKey: false
        updated: true
        isNull: true
        mysqlType: "varchar(255)"
        ]
        UPDATE
        [index: 0
        sqlType: 4
        name: "id"
        isKey: true
        updated: false
        isNull: false
        value: "1"
        mysqlType: "int"
        , index: 1
        sqlType: 12
        name: "nick"
        isKey: false
        updated: false
        isNull: false
        value: "cat"
        mysqlType: "varchar(255)"
        , index: 2
        sqlType: 12
        name: "phone"
        isKey: false
        updated: false
        isNull: false
        value: "13822211"
        mysqlType: "varchar(255)"
        , index: 3
        sqlType: 12
        name: "password"
        isKey: false
        updated: false
        isNull: true
        mysqlType: "varchar(255)"
        , index: 4
        sqlType: 12
        name: "email"
        isKey: false
        updated: true
        isNull: false
        value: "hxasiadsi@qq.com"
        mysqlType: "varchar(255)"
        , index: 5
        sqlType: 12
        name: "account"
        isKey: false
        updated: false
        isNull: true
        mysqlType: "varchar(255)"
        ]
        UPDATE
        [index: 0
        sqlType: 4
        name: "id"
        isKey: true
        updated: false
        isNull: false
        value: "1"
        mysqlType: "int"
        , index: 1
        sqlType: 12
        name: "nick"
        isKey: false
        updated: false
        isNull: false
        value: "cat"
        mysqlType: "varchar(255)"
        , index: 2
        sqlType: 12
        name: "phone"
        isKey: false
        updated: false
        isNull: false
        value: "13822211"
        mysqlType: "varchar(255)"
        , index: 3
        sqlType: 12
        name: "password"
        isKey: false
        updated: true
        isNull: false
        value: "1234567"
        mysqlType: "varchar(255)"
        , index: 4
        sqlType: 12
        name: "email"
        isKey: false
        updated: false
        isNull: false
        value: "hxasiadsi"
        mysqlType: "varchar(255)"
        , index: 5
        sqlType: 12
        name: "account"
        isKey: false
        updated: true
        isNull: false
        value: "sssss"
        mysqlType: "varchar(255)"
        ]
        msgId -> 3
        INSERT
        [index: 0
        sqlType: 4
        name: "id"
        isKey: true
        updated: true
        isNull: false
        value: "2"
        mysqlType: "int"
        , index: 1
        sqlType: 12
        name: "nick"
        isKey: false
        updated: true
        isNull: false
        value: "333333"
        mysqlType: "varchar(255)"
        , index: 2
        sqlType: 12
        name: "phone"
        isKey: false
        updated: true
        isNull: false
        value: "333333"
        mysqlType: "varchar(255)"
        , index: 3
        sqlType: 12
        name: "password"
        isKey: false
        updated: true
        isNull: false
        value: "333333"
        mysqlType: "varchar(255)"
        , index: 4
        sqlType: 12
        name: "email"
        isKey: false
        updated: true
        isNull: false
        value: "3333"
        mysqlType: "varchar(255)"
        , index: 5
        sqlType: 12
        name: "account"
        isKey: false
        updated: true
        isNull: false
        value: "www"
        mysqlType: "varchar(255)"
        ]
         
        Process finished with exit code 137 (interrupted by signal 9: SIGKILL)
            