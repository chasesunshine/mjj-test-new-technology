# @ModelAttribute
    https://blog.csdn.net/abc997995674/article/details/80464023?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-80464023-blog-80334027.235%5Ev43%5Econtrol&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-80464023-blog-80334027.235%5Ev43%5Econtrol&utm_relevant_index=2

    查看 @ModelAttribute注解定义可以看到这个注解可以用在方法和参数中。
    在 SpringMVC 的 Controller 中使用 @ModelAttribute 时，应用情况包括下面几种：
    1、应用在方法上。
    2、应用在方法的参数上。
    3、应用在方法上，并且方法也使用了@RequestMapping

原文链接：https://blog.csdn.net/abc997995674/article/details/80464023

# ＠InitBinder
    https://blog.csdn.net/weixin_43888891/article/details/127348918?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-1-127348918-blog-121334254.235%5Ev43%5Econtrol&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-1-127348918-blog-121334254.235%5Ev43%5Econtrol&utm_relevant_index=2

    @InitBinder从字面意思可以看出这个的作用是给Binder做初始化的，@InitBinder主要用在@Controller中标注于方法上（@RestController也算），
    表示初始化当前控制器的数据绑定器（或者属性绑定器），只对当前的Controller有效。
    @InitBinder标注的方法必须有一个参数WebDataBinder。
    所谓的属性编辑器可以理解就是帮助我们完成参数绑定，然后是在请求到达controller要执行方法前执行！
    