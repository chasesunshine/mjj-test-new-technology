# url
    https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=InitBinder%E6%B3%A8%E8%A7%A3%20%E4%BD%BF%E7%94%A8%E6%A1%88%E4%BE%8B&fenlei=256&oq=InitBinder%25E6%25B3%25A8%25E8%25A7%25A3&rsv_pq=f42476f80015d624&rsv_t=28b0sySjfP%2BUBcaGG%2BUP56%2F5oO1sjiyKvxDUTu6bq93IinVlxWEk1nndX%2Bk&rqlang=cn&rsv_enter=1&rsv_dl=tb&rsv_btype=t&rsv_sug3=44&rsv_sug1=40&rsv_sug7=100&rsv_sug2=0&inputT=4983&rsv_sug4=7280

# demo 
    java
    import org.springframework.web.bind.WebDataBinder;
    import org.springframework.web.bind.annotation.InitBinder;
    import org.springframework.stereotype.Controller;
    import java.util.Date;
    
    @Controller
    public class MyController {
    
        @InitBinder
        public void initBinder(WebDataBinder binder) {
            // 注册一个自定义的编辑器，将所有传入的字符串转换为大写
            binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
                @Override
                public void setAsText(String text) {
                    setValue(text.toUpperCase());
                }
            });
    
            // 注册一个自定义的编辑器，将所有传入的日期格式化为 yyyy/MM/dd 格式
            binder.registerCustomEditor(Date.class, new CustomDateEditor(
                    new SimpleDateFormat("yyyy/MM/dd"), true));
        }
    
        // 控制器的其他方法...
    }
    
    这个例子中，我们定义了一个控制器MyController，并使用@InitBinder注解标记了一个方法，该方法会在控制器的任何请求处理方法被调用之前执行。在这个方法内部，我们注册了两个自定义编辑器：一个是将所有字符串转换为大写的自定义编辑器，
    另一个是将日期格式化为yyyy/MM/dd格式的自定义编辑器。这样，当表单提交的数据被绑定到模型时，这些自定义转换会被应用。

# springMvc@InitBinder()註解的使用
    https://www.cnblogs.com/HYV587/p/14971047.html

    引：第一次接触这个注解的时候,是由于测试员代码扫描中出现了
    (Mass Assignment:Insecure Binder Configuration)的高危漏洞信息,
    而@InitBinder()注解则是该漏洞的解决方案。
    
    @InitBinder()注解的常用用详解
    用法一：绑定同属性多对象
    @InitBinder("object") public void initBinder(WebDataBinder binder) { binder.setFieldDefaultPrefix("object");//对象前缀 }
    用法二:可以让参数某个属性无法被接收
    @InitBinder() public void initBinder(WebDataBinder binder) { //让某些属性无法被接收 binder.setDisallowedFields("test"); }
    用法三:类型转换
    @InitBinder() public void initBinder(WebDataBinder binder) { //比如日期预处理 binder.addCustomFormatter(new DateFormatter("yyyy-mm-dd")); }


# @InitBinder处理指定前缀参数
    https://blog.csdn.net/qq_44930716/article/details/123825194

    入参需要带上 前缀