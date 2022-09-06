package org.wanbang.test;


import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.study.disruptorStudy.disruptor3Main.DisruptorTest2;
import org.wanbang.study.disruptorStudy.disruptor3Main.event.MessageEvent;
import org.wanbang.study.disruptorStudy.disruptorOwnerPackage.operateutils.DisruptorOperate;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestDisruptor {
	@Resource
	private Disruptor disruptor;

	@Resource
	private DisruptorOperate disruptorOperate;

	@Test
	public void testDisruptor1() throws InterruptedException {
		String message1 = "Hello Disruptor1!";
		String message2 = "Hello Disruptor2!";

		disruptorOperate.publishEvent(message1);
//		disruptorOperate.shutDown();

		Thread.sleep(3000);
		disruptorOperate.publishEvent(message2);

	}


//	@Test
//	public void testDisruptor2() throws InterruptedException {
//		String message1 = "Hello Disruptor1!";
//		String message2 = "Hello Disruptor2!";
//
//		// 启动 disruptor 返回 RingBuffer对象
//		RingBuffer<MessageEvent> ringBuffer = disruptor.start();
//
//		// 将接收到的消息输出到ringBuffer
//		EventTranslatorOneArg<MessageEvent,String> translator = new MessageEventTranslator();
//		ringBuffer.publishEvent(translator,message1);
//
//		Thread.sleep(5000);
//		ringBuffer.publishEvent(translator,message2);
//
//	}

}
