package com.something.designPattern.singleton.example;

/**
 * 单例模式 - 饿汉式
 * <p>
 * 在类加载的时候就会初始化唯一的对象
 * <p>
 * 缺点：减慢程序启动速度，且该实例不一定会被用到（在企业应用中基本不存在这种情况）
 */
public class Singleton_01 {

    // 实例化全剧唯一对象
    private static Singleton_01 instance = new Singleton_01();

    // 构造方法私有化，防止外部调用
    private Singleton_01() {
    }

    // 对外暴露获取全局唯一实例的方法
    public static Singleton_01 getInstance() {
        return instance;
    }
}
