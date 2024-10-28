在Spring Boot中插入数据到MongoDB可以通过Spring Data MongoDB实现。以下是一个简单的例子：

首先，在pom.xml中添加Spring Data MongoDB依赖：

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
在Spring Boot应用的配置文件application.properties或application.yml中配置MongoDB连接信息：

# application.properties
spring.data.mongodb.uri=mongodb://username:password@localhost:27017/database
或者使用YAML格式：

# application.yml
spring:
  data:
    mongodb:
      uri: mongodb://username:password@localhost:27017/database
创建一个实体类来表示MongoDB中的文档：

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 
@Document
public class MyDocument {
    @Id
    private String id;
    private String data;
 
    // Getters and Setters
}
创建一个MongoDB仓库接口：

import org.springframework.data.mongodb.repository.MongoRepository;
 
public interface MyDocumentRepository extends MongoRepository<MyDocument, String> {
}
在服务层中使用仓库接口插入数据：

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class MyDocumentService {
 
    @Autowired
    private MyDocumentRepository repository;
 
    public MyDocument insertData(String data) {
        MyDocument document = new MyDocument();
        document.setData(data);
        return repository.insert(document);
    }
}
在控制器中调用服务层插入数据：

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/documents")
public class MyDocumentController {
 
    @Autowired
    private MyDocumentService service;
 
    @PostMapping
    public MyDocument insertData(@RequestParam String data) {
        return service.insertData(data);
    }
}
当你调用/documents端点时，将会在MongoDB中插入一个新的文档。