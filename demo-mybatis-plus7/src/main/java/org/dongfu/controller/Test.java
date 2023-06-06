package org.dongfu.controller;

import java.util.HashMap;
import java.util.Stack;

public class Test {
    static Stack<Object> object1 = new Stack<>();
    static Stack<Object> object2 = new Stack<>();

    public static void main(String[] args) {
        HashMap<Integer, String> value = new HashMap<>();

        value.put(1,"1");
        value.put(2,"2");
        value.put(3,"3");
        value.put(4,"4");
        value.put(5,"5");
        value.put(6,"6");
        value.put(7,"7");
        value.put(8,"8");
        value.put(9,"9");
        value.put(10,"10");
        value.put(11,"11");
        value.put(12,"12");
        value.put(13,"13");
        value.put(14,"14");
        value.put(15,"15");
    }

//    public static void main(String[] args) {
//        in(1);
//        in(2);
//        in(3);
//
//        Object out = out();
//        System.out.println(out);
//
//    }

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


