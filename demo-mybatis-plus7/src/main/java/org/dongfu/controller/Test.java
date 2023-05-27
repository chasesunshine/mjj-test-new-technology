package org.dongfu.controller;

import java.util.Stack;

public class Test {
    static Stack<Object> object1 = new Stack<>();
    static Stack<Object> object2 = new Stack<>();

    public static void main(String[] args) {
        in(1);
        in(2);
        in(3);

        Object out = out();
        System.out.println(out);

    }

    public static Object out(){
        while (!object2.empty()){
            object1.push(object2.pop());
        }
        if(!object1.empty()){
            return object1.pop();
        }
        return null;
    }

    public static void in(Object value){
        object2.push(value);
    }

}


