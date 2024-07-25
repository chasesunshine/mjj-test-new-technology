# @ModelAttribute运用详解
    https://www.cnblogs.com/jpfss/p/10768125.html

    2.@ModelAttribute注释一个方法的参数 
        （1）从model中获取
        @Controller
        public class HelloWorldController {
        @ModelAttribute("user")
        public User addAccount() {
        return new User("jz","123");
        }
        
            @RequestMapping(value = "/helloWorld")
            public String helloWorld(@ModelAttribute("user") User user) {
                   user.setUserName("jizhou");
                   return "helloWorld";
                }
        }
    在这个例子里，@ModelAttribute("user") User user注释方法参数，参数user的值来源于addAccount()方法中的model属性。
　　此时如果方法体没有标注@SessionAttributes("user")，那么scope为request，如果标注了，那么scope为session
    
    ## 个人操作案例
        org.wanbang.controller.SpringWordTestController