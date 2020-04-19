package com.something.designPattern.singleton.example;

/**
 * 单例模式 - 静态内部类
 * <p>
 * 通过为Singleton引入静态内部类Holder，在其静态内部类中持有全局唯一的实例对象
 * <p>
 * 这种方式解决类饿汉式中在类加载时期直接实例化对象的问题，在第一次调用getInstance()方法时才会去加载内部的Holder类，
 * 从而达到延迟加载的目的。
 */
public class Singleton_05 {

    // 构造方法私有化
    private Singleton_05() {

    }

    // 对外暴露获取方法
    public static Singleton_05 getInstance() {
        return Holder.instance;
    }

    private static class Holder {

        /*static {
            System.out.println("holder loaded.");
        }*/

        // 持有全局唯一实例
        private static Singleton_05 instance = new Singleton_05();
    }
}
