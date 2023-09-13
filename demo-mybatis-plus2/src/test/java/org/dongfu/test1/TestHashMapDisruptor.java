package org.dongfu.test1;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestHashMapDisruptor {
//	@Resource
//	private Disruptor disruptor;
//
//	@Test
//	public void testDisruptor1() throws InterruptedException {
//		String message1 = "Hello Disruptor1!";
//		String message2 = "Hello Disruptor2!";
//
//		// 启动 disruptor 返回 RingBuffer对象
//		RingBuffer<MessageEvent> ringBuffer = disruptor.start();
//
//		// 将接收到的消息输出到ringBuffer
//		EventTranslatorOneArg<MessageEvent,String> translator = new DisruptorTest2.MessageEventTranslator();
//		ringBuffer.publishEvent(translator,message1);
//		disruptor.shutdown();
//
//		Thread.sleep(5000);
//		ringBuffer.publishEvent(translator,message2);
//
//	}
//
//
//	@Test
//	public void testDisruptor2() throws InterruptedException {
//		String message1 = "Hello Disruptor1!";
//		String message2 = "Hello Disruptor2!";
//
//		// 启动 disruptor 返回 RingBuffer对象
//		RingBuffer<MessageEvent> ringBuffer = disruptor.start();
//
//		// 将接收到的消息输出到ringBuffer
//		EventTranslatorOneArg<MessageEvent,String> translator = new DisruptorTest2.MessageEventTranslator();
//		ringBuffer.publishEvent(translator,message1);
//
//		Thread.sleep(5000);
//		ringBuffer.publishEvent(translator,message2);
//
//	}

}
