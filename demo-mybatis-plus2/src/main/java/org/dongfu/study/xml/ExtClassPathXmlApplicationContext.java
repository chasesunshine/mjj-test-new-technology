package org.dongfu.study.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.List;

/**
 * 自定义spring容器框架 xml方式实现
 * Created by yz on 2018/6/3.
 */
public class ExtClassPathXmlApplicationContext {

    // xml读取路径地址
    private String xmlPath;

    public ExtClassPathXmlApplicationContext(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public Object getBean(String beanId) throws Exception {
        if(StringUtils.isEmpty(beanId)){
            return new Exception("bendId不能为空");
        }
        // 1.解析xml,获取所有bean节点信息
        List<Element> readerxml = readeXml(xmlPath);
        // 2.使用方法参数bend id查找配置文件中bean节点的id信息是否一致。
        if(readerxml == null || readerxml.isEmpty()){
            return new Exception("配置文件中，没有配置bean信息");
        }
        String className = findByElementClass(readerxml, beanId);
        if(StringUtils.isEmpty(className)){
            return new Exception("该bean对象没有配置class地址");
        }
        // 3.获取class信息地址，使用反射机制初始化
        return newInstance(className);
    }

    // 重构
    public String findByElementClass(List<Element> readerxml,String beanId) throws Exception {
        for (Element element : readerxml) {
            // 获取属性信息
            String xmlbeanId = element.attributeValue("id");
            if(StringUtils.isEmpty(xmlbeanId)){
                continue;
            }
            if(xmlbeanId.equals(beanId)){
                String xmlClassPath = element.attributeValue("class");
                return xmlClassPath;
            }
        }
        return null;
    }

    // 根据路径通过反射机制获取对象
    public Object newInstance(String className) throws Exception {
        Class<?> classInfo = Class.forName(className);
        return classInfo.getDeclaredConstructor().newInstance();
    }

    // 解析xml
    public List<Element> readeXml(String xmlPath) throws DocumentException {
        // 1.解析xml信息
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(getResourcesAsStream(xmlPath));
        // 2.读取节点下所有的子节点
        Element rootElement = document.getRootElement();
        // 3.获取根节点下所有的子节点
        List<Element> elements = rootElement.elements();
        return elements;
    }

    // 获取当前上下文
    public InputStream getResourcesAsStream(String xmlPath){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(xmlPath);
        return inputStream;
    }

}