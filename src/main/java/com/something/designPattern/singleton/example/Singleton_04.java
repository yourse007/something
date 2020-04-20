package com.something.designPattern.singleton.example;

/**
 * 单例模式 - 双重检索(DCL.)
 * <p>
 * 双重检索机制(double-checked locking)保证线程安全
 * <p>
 * 懒加载，在程序中第一次用到该实例的时候，才会执行初始化操作
 * <p>
 * 这里使用{@code synchronized}保证变量在线程之间的可见性，以及实例化操作的排他性
 * 另外还要依赖于{@code volatile}保证虚拟机不会对指令进行重排序
 * <p>
 * DCL单例模式的写法相对来说很麻烦，涉及到的多线程原理比较多，但是这种方式在保证高并发
 * 下的线程安全之外，也实现了懒加载的效果
 *
 * @see synchronized
 * @see volatile
 */
public class Singleton_04 {

    // 唯一实例
    private static volatile Singleton_04 instance = null;

    // 构造方法私有化
    private Singleton_04() {

    }

    // 对外暴露方法
    public static Singleton_04 getInstance() {
        if (instance == null) {
            synchronized (Singleton_04.class) {
                if (instance == null) {
                    instance = new Singleton_04();
                }
            }
        }
        return instance;
    }
}
