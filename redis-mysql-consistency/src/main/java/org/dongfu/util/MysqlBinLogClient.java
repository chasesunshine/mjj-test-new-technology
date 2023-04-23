package org.dongfu.util;
/**
 * @description: TODO
 * @author majiajian
 * @date 2023/4/16 14:22
 * @version 1.0
 */
//为什么甚至路径都一样，还是com.github.shyiko.***，
// 因为com.zendesk这个包，里面包了个com.github.shyiko.***这玩意，我怀疑是收购关系
import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//此类可以监控MySQL库数据的增删改
@Component
@Slf4j  //用于打印日志
//在SpringBoot中，提供了一个接口：ApplicationRunner。
//该接口中，只有一个run方法，他执行的时机是：spring容器启动完成之后，就会紧接着执行这个接口实现类的run方法。
public class MysqlBinLogClient implements ApplicationRunner {
    private static ConcurrentHashMap<Long,String> tableIdMap = new ConcurrentHashMap<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //项目启动完成连接bin-log
        new Thread(() -> {
            connectMysqlBinLog();
        }).start();

    }

    /**
     * 连接mysqlBinLog
     */
    public void connectMysqlBinLog() {
        log.info("监控BinLog服务已启动");

        //自己MySQL的信息。host，port，username，password
        BinaryLogClient client = new BinaryLogClient("localhost", 3306, "root", "root");
        /**
         * 因为binlog不是以数据库为单位划分的，所以监控binglog不是监控的单个的数据库，而是整个当前所设置连接的MySQL，
         *其中任何一个库发生数据增删改，这里都能检测到，
         *所以不用设置所监控的数据库的名字(我也不知道怎么设置，没发现有包含这个形参的构造函数)
         *如果需要只监控指定的数据库，可以看后面代码，可以获取到当前发生变更的数据库名称。可以根据名称来决定是否监控
         *
         **/

        client.setServerId(100); //和自己之前设置的server-id保持一致，但是我不知道为什么不一致也能成功

        //下面直接照抄就行
        client.registerEventListener(
                event -> {
                    EventData data = event.getData();
                    if (data instanceof TableMapEventData) {
                        //只要连接的MySQL发生的增删改的操作，则都会进入这里，无论哪个数据库

                        TableMapEventData tableMapEventData = (TableMapEventData) data;

                        //可以通过转成TableMapEventData类实例的tableMapEventData来获取当前发生变更的数据库
                        System.out.println("发生变更的数据库："+tableMapEventData.getDatabase());

                        System.out.print("TableID:");
                        //表ID
                        System.out.println(tableMapEventData.getTableId());
                        System.out.print("TableName:");
                        //表名字
                        System.out.println(tableMapEventData.getTable());

                        tableIdMap.put(tableMapEventData.getTableId(),tableMapEventData.getTable());
                    }

                    //表数据发生修改时触发
                    if (data instanceof UpdateRowsEventData) {
                        String table = tableIdMap.get(((UpdateRowsEventData) data).getTableId());
                        if(table.equals("redis_mysql_consistency")){
                            System.out.println("Update:");
                            System.out.println(data.toString());
                        }

                        //表数据发生插入时触发
                    } else if (data instanceof WriteRowsEventData) {
                        String table = tableIdMap.get(((WriteRowsEventData) data).getTableId());
                        if(table.equals("redis_mysql_consistency")){
                            System.out.println("Insert:");
                            System.out.println(data.toString());
                        }

                        //表数据发生删除后触发
                    } else if (data instanceof DeleteRowsEventData) {
                        String table = tableIdMap.get(((DeleteRowsEventData) data).getTableId());
                        if(table.equals("redis_mysql_consistency")){
                            System.out.println("Delete:");
                            System.out.println(data.toString());
                        }

                    }
                });

        try {
            client.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
