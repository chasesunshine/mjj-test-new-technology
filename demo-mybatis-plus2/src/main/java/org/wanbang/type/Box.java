package org.wanbang.type;

public class Box<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    // 泛型方法 printArray
    public static < E > void printArray( E[] inputArray )
    {
        for ( E element : inputArray ){
            System.out.printf( "%s ", element );
        }
    }
}
