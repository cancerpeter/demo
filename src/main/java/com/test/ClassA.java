package com.test;

public class ClassA {

    // 定义静态变量
    public static ClassC classc = new ClassC();

    static {
        System.out.println("ClassA的静态代码块");
    }

    public ClassA() {
        System.out.println("ClassA的构造方法");
    }

    //构造代码块
    {
        System.out.println("ClassA的构造代码块");
    }
}