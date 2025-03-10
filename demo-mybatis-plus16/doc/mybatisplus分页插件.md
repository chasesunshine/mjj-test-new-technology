MyBatis-Plus 是一个强大的 MyBatis 增强工具，提供了许多便捷的功能，其中包括分页插件。使用 MyBatis-Plus 的分页插件可以轻松实现分页查询。

1. 添加依赖
    首先，你需要在 pom.xml 中添加 MyBatis-Plus 的依赖：
    
        xml
        复制
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>最新版本</version>
        </dependency>
        运行 HTML
2. 配置分页插件
在 Spring Boot 项目中，你可以通过配置类来启用分页插件：

        java
        复制
        import com.baomidou.mybatisplus.annotation.DbType;
        import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
        import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        
        @Configuration
        public class MybatisPlusConfig {
        
            @Bean
            public MybatisPlusInterceptor mybatisPlusInterceptor() {
                MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
                // 添加分页插件
                interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL)); // 数据库类型可以根据实际情况调整
                return interceptor;
            }
        }
3. 使用分页功能
        在 Service 或 Mapper 中，你可以使用 Page 对象来进行分页查询：
        
        java
        复制
        import com.baomidou.mybatisplus.core.metadata.IPage;
        import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        
        @Service
        public class UserServiceImpl implements UserService {
        
            @Autowired
            private UserMapper userMapper;
        
            @Override
            public IPage<User> selectUserPage(int pageNum, int pageSize) {
                // 创建分页对象
                Page<User> page = new Page<>(pageNum, pageSize);
                // 执行分页查询
                return userMapper.selectPage(page, null);
            }
        }
4. 在 Controller 中调用
        在 Controller 中，你可以调用 Service 中的分页方法，并将结果返回给前端：
        
        java
        复制
        import com.baomidou.mybatisplus.core.metadata.IPage;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;
        
        @RestController
        public class UserController {
        
            @Autowired
            private UserService userService;
        
            @GetMapping("/users")
            public IPage<User> getUsers(@RequestParam int pageNum, @RequestParam int pageSize) {
                return userService.selectUserPage(pageNum, pageSize);
            }
        }
5. 分页参数说明
        pageNum: 当前页码，从 1 开始。
        
        pageSize: 每页显示的记录数。
        
        total: 总记录数。
        
        records: 当前页的数据列表。

6. 自定义分页查询
        如果你需要自定义分页查询，可以在 Mapper 中编写 SQL 并使用 IPage 作为参数：
        
        java
        复制
        import com.baomidou.mybatisplus.core.mapper.BaseMapper;
        import com.baomidou.mybatisplus.core.metadata.IPage;
        import org.apache.ibatis.annotations.Param;
        
        public interface UserMapper extends BaseMapper<User> {
        
            IPage<User> selectUserPageCustom(IPage<User> page, @Param("name") String name);
        }
        然后在 XML 文件中编写 SQL：
        
        xml
        复制
        <select id="selectUserPageCustom" resultType="User">
            SELECT * FROM user WHERE name = #{name}
        </select>
        运行 HTML
7. 前端分页
        前端可以根据返回的分页数据进行分页展示，常见的分页组件有 Element UI、Ant Design 等。

总结
MyBatis-Plus 的分页插件非常方便，通过简单的配置和使用，可以轻松实现分页功能。你可以根据实际需求进行自定义分页查询，并将分页数据返回给前端展示。

