package org.wanbang.test1;


import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.InetSocketAddress;
import java.util.List;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestMjj {

    private final static int BATCH_SIZE = 10000;

    @Test
    public void startMonitorSQL() {
        while (true) {
            //canal，canal是刚才mysql为canal创建的用户的账号和密码
            CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress("127.0.0.1", 11111), "example", "canal", "canal");
            String canalMonitorTableName="test";

            try {
                //打开连接
                connector.connect();
                System.out.println("数据库检测连接成功!" + canalMonitorTableName);
                //订阅数据库表,全部表q
                connector.subscribe("test.test");
                //回滚到未进行ack的地方，下次fetch的时候，可以从最后一个没有ack的地方开始拿
                connector.rollback();
                while (true) {
                    // 获取指定数量的数据
                    Message message = connector.getWithoutAck(BATCH_SIZE);
                    long batchId = message.getId();
//                    System.out.println("position:"+batchId);
                    int size = message.getEntries().size();
                    if (batchId == -1 || size == 0) {
                    } else {
//                        System.out.println("解析到一条数据------------>"+message.getEntries());
                        handleDATAChange(message.getEntries());
                    }
                    // 提交确认
                    connector.ack(batchId);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("成功断开监测连接!尝试重连");
            } finally {
                connector.disconnect();
                //防止频繁访问数据库链接: 线程睡眠 10秒
                try {
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 打印canal server解析binlog获得的实体类信息
     */
    private void handleDATAChange(List<CanalEntry.Entry> entrys) {
        for (CanalEntry.Entry entry : entrys) {
            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                continue;
            }
            //RowChange对象，包含了一行数据变化的所有特征
            CanalEntry.RowChange rowChage;
            try {
                rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(), e);
            }
            CanalEntry.EventType eventType = rowChage.getEventType();
            if (eventType == CanalEntry.EventType.INSERT){
                try {
                    CanalEntry.RowChange rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
                    for (int i = 0; i < rowChange.getRowDatasCount(); i++) {
                        CanalEntry.RowData rowDatas = rowChange.getRowDatas(i);
                        String id=rowDatas.getAfterColumns(0).getValue();
                        String date=rowDatas.getAfterColumns(1).getValue();
                        String order=rowDatas.getAfterColumns(2).getValue();
                        System.out.println(id+"---"+date+"---"+order);
                    }
                } catch (InvalidProtocolBufferException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
