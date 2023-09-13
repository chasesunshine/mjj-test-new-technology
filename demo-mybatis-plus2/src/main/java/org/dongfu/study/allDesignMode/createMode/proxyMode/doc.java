package org.dongfu.study.allDesignMode.createMode.proxyMode;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 11:33
* @version 1.0
*/

/**
 * InvocationHandler和Proxy(Class)的动态代理机制详解
 * https://blog.csdn.net/yangaiyu/article/details/73827043
 */
public class doc {
//    首先我们定义了一个Subject类型的接口，为其声明了两个方法：
//    接着，定义了一个类来实现这个接口，这个类就是我们的真实对象，RealSubject类：
//    下一步，我们就要定义一个动态代理类了，前面说个，每一个动态代理类都必须要实现 InvocationHandler 这个接口，因此我们这个动态代理类也不例外：
//    最后，来看看我们的Client类：

    //个人理解
    // 调用方法 subject.rent() 的时候才会执行  DynamicProxy 的 invoke方法




//    我们首先来看看 $Proxy0 这东西，我们看到，这个东西是由 System.out.println(subject.getClass().getName());
//    这条语句打印出来的，那么为什么我们返回的这个代理对象的类名是这样的呢？
//    Subject subject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(),
//                                                      realSubject.getClass().getInterfaces(),
//                                                      handler);
//    可能我以为返回的这个代理对象会是Subject类型的对象，或者是InvocationHandler的对象，结果却不是，
//    首先我们解释一下为什么我们这里可以将其转化为Subject类型的对象？原因就是在newProxyInstance这个方法的第二个参数上，
//    我们给这个代理对象提供了一组什么接口，那么我这个代理对象就会实现了这组接口，
//    这个时候我们当然可以将这个代理对象强制类型转化为这组接口中的任意一个，因为这里的接口是Subject类型，
//    所以就可以将其转化为Subject类型了。
//    同时我们一定要记住，通过 Proxy.newProxyInstance 创建的代理对象是在jvm运行时动态生成的一个对象，
//    它并不是我们的InvocationHandler类型，也不是我们定义的那组接口的类型，而是在运行是动态生成的一个对象，
//    并且命名方式都是这样的形式，以$开头，proxy为中，最后一个数字表示对象的标号。
//
//    接着我们来看看这两句
//      subject.rent();
//      subject.hello("world");
//    这里是通过代理对象来调用实现的那种接口中的方法，这个时候程序就会跳转到由这个代理对象关联到的 handler 中的invoke方法去执行，而我们的这个 handler 对象又接受了一个 RealSubject类型的参数，表示我要代理的就是这个真实对象，所以此时就会调用 handler 中的invoke方法去执行：
}
