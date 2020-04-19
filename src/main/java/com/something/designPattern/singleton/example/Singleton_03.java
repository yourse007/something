package com.something.designPattern.singleton.example;

/**
 * 单例模式 - 懒汉式(线程安全)
 * <p>
 * 懒加载，在程序中第一次用到该实例的时候，才会执行初始化操作
 * <p>
 * 由于在getInstance方法上加了synchronized关键字，保证了多个线程顺序执行该方法的代码，所以线程安全
 * <p>
 * 缺点：
 * 在高并发的情况下，每次获取单例对象都需要获取同步的锁，影响并发性能
 */
public class Singleton_03 {

    private static Singleton_03 instance = null;

    private Singleton_03() {

    }

    public static synchronized Singleton_03 getInstance() {
        if (instance == null) {
            instance = new Singleton_03();
        }
        return instance;
    }

}
