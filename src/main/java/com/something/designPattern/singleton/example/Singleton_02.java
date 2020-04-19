package com.something.designPattern.singleton.example;

/**
 * 单例模式 - 懒汉式
 *
 * 懒加载，在程序中第一次用到该实例的时候，才会执行初始化操作
 *
 * 此方式需要保证线程安全，防止多个线程实例化出多个对象
 * 所以在实例化的时候，这里使用{@code synchronized}保证变量在线程之间的可见性，以及实例化操作的排他性
 * 另外还要依赖于{@code volatile}保证虚拟机不会对指令进行重排序
 *
 * @see synchronized
 * @see volatile
 */
public class Singleton_02 {

    // 唯一实例
    private static volatile Singleton_02 instance = null;

    // 构造方法私有化
    private Singleton_02() {

    }

    // 对外暴露方法
    public static Singleton_02 getInstance() {
        if (instance == null) {
            synchronized (Singleton_02.class) {
                if (instance == null) {
                    instance = new Singleton_02();
                }
            }
        }
        return instance;
    }
}
