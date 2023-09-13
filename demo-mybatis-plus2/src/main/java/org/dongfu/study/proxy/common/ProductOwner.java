package org.dongfu.study.proxy.common;

import lombok.NoArgsConstructor;

// Cglib代理 必须要无参构造函数
@NoArgsConstructor
public class ProductOwner {
    private String name;
    public ProductOwner(String name){
        this.name = name;
    }
    public void defineBackLog(){
        System.out.println("PO: " + name + " defines Backlog.");
    }
}