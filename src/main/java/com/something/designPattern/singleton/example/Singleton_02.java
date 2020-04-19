package com.something.designPattern.singleton.example;

/**
 * 单例模式 - 懒汉式(线程不安全)
 * <p>
 * 懒加载，在程序中第一次用到该实例的时候，才会执行初始化操作
 * <p>
 * 这种方式在单线程环境下没有问题，但是在并发的情况下可能存在不同的线程分别实例化不同对象的情况，
 * 所以在多线程环境下不适用
 */
public class Singleton_02 {

    private static Singleton_02 instance = null;

    private Singleton_02() {

    }

    public static Singleton_02 getInstance() {
        if (instance == null) {
            instance = new Singleton_02();
        }
        return instance;
    }
}
