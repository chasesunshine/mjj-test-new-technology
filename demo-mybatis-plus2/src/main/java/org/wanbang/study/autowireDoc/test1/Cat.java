package org.wanbang.study.autowireDoc.test1;

public class Cat {
    public Cat(){
        System.out.println("执行 cat构造方法");
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void shout(){
        System.out.println("miao~");
    }
}
