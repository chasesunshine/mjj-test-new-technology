package org.dongfu.study.optional;

/**
 * Optional 使用方法详解
 *
 * https://blog.csdn.net/weixin_43888891/article/details/124788806
 *
 */
public class Doc {
    /**
     *
     * 一、Optional类的来源
     * 到目前为止，臭名昭著的空指针异常是导致Java应用程序失败的最常见原因。以前，为了解决空指针异常，Google公司著名的Guava项目引入了Optional类，
     * Guava通过使用检查空值的方式来防止代码污染，它鼓励程序员写更干净的代码。受到Google Guava的启发，Optional类已经成为Java 8类库的一部分。
     *
     *
     *
     * 二、Optional类是什么？
     * Optional 类(java.util.Optional) 是一个容器类，它可以保存类型T的值，代表这个值存在。或者仅仅保存null，表示这个值不存在。
     * 原来用 null 表示一个值不存在，现在 Optional 可以更好的表达这个概念。并且可以避免空指针异常。
     *
     * Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
     *
     *
     *
     *
     * 三、Optional类用法
     * Optional类的Javadoc描述如下：这是一个可以为null的容器对象。
     * 如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
     * 如果值不存在则isPresent()方法会返回false，调用get()方法会NPE。
     *
     * 创建Optional类对象的方法：
     *      Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
     *      Optional.empty() : 创建一个空的 Optional 实例
     *      Optional.ofNullable(T t)：t可以为null
     *
     * 判断Optional容器中是否包含对象：
     *      boolean isPresent() : 判断是否包含对象
     *      void ifPresent(Consumer<? super T> consumer) ：如果有值，就执行Consumer接口的实现代码，并且该值会作为参数传给它。
     *
     * 获取Optional容器的对象：
     *      T get(): 如果调用对象包含值，返回该值，否则抛异常
     *      T orElse(T other) ：如果有值则将其返回，否则返回指定的other对象。
     *      T orElseGet(Supplier<? extends T> other) ：如果有值则将其返回，否则返回由Supplier接口实现提供的对象。
     *      T orElseThrow(Supplier<? extends X> exceptionSupplier) ：如果有值则将其返回，否则抛出由Supplier接口实现提供的异常。
     *
     * 过滤：
     *      Optional<T> filter(Predicate<? super <T> predicate)：如果值存在，并且这个值匹配给定的 predicate，返回一个Optional用以描述这个值，否则返回一个空的Optional。
     *
     * 映射:
     *      <U>Optional<U> map(Function<? super T,? extends U> mapper)：如果有值，则对其执行调用映射函数得到返回值。如果返回值不为 null，
     *      则创建包含映射返回值的Optional作为map方法返回值，否则返回空Optional。
     *      <U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)：如果值存在，就对该值执行提供的mapping函数调用，
     *      返回一个Optional类型的值，否则就返回一个空的Optional对象
     *
     */
}
