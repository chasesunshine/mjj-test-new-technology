package org.wanbang.test;

import java.lang.reflect.Field;

public class EnumSet<T> {
    public static <T> T allof(Class object) throws InstantiationException, IllegalAccessException {
        if(object.isEnum()){
            Field[] fields = object.getClass().getFields();
            if(fields.length < 64){
                EnumSet<Thread.State> value = new EnumSet<>();
                return (T) value;
            }else {
                EnumSet<Character.UnicodeScript> value = new EnumSet<>();
                return (T) value;
            }
        }
        return null;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        // Thread.state是少于64个元素的enum
        EnumSet<Thread.State> es1 = EnumSet.allof(Thread.State.class);
        // character.Unicodescript是多于64个元素的enum
        EnumSet<Character.UnicodeScript> es2 = EnumSet.allof(Character.UnicodeScript.class);
        //打印出es1的类型为ReqularEnumSet
        System.out.println(es1.getClass());
        //打印出es2的类型为JumboEnumSet
        System.out.println(es2.getClass());
    }
}
