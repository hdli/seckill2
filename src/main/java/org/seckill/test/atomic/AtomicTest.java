package org.seckill.test.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hdli on 2018-2-2.
 */
public class AtomicTest {

    public static void main(String[] args) {
        atomicIntegerTest();
    }

    public static void atomicIntegerTest(){
        AtomicInteger integer = new AtomicInteger(0);
        int i = integer.getAndAdd(1);
        System.out.println("getAndAdd()方法返回的是原来的值为："+i);
        System.out.println("最新的integer值为："+integer.get());
    }
}
