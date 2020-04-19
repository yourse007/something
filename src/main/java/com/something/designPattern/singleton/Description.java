package com.something.designPattern.singleton;

import com.something.designPattern.singleton.example.*;
/**
 * 单例模式
 *
 * 单例模式是指无论在什么时间点使用某个类的对象，获取到的都是同一个、全局唯一的实例。
 *
 * 适用场景：针对于全局适用的类，始终维护一个全局唯一的实例，避免频繁地创建和销毁。
 * 好处：1. 节省系统资源； 2. 提升系统性能；
 *
 * 思路：由单例类本身创建出唯一的实例，不对外提供构造方法。
 *
 * 单例模式有多种实现方法，example包下罗列了常见的实现方式
 *
 * @see Singleton_01 饿汉式
 */
public class Description {

    public static void main(String[] args) {

        Singleton_01 singleton_01 = Singleton_01.getInstance();
        Singleton_01 singleton_011 = Singleton_01.getInstance();
        System.out.println(singleton_01 == singleton_011);

        Singleton_02 singleton_02 = Singleton_02.getInstance();
        Singleton_02 singleton_021 = Singleton_02.getInstance();
        System.out.println(singleton_02 == singleton_021);

        Singleton_03 singleton_03 = Singleton_03.INSTANCE;
        Singleton_03 singleton_031 = Singleton_03.INSTANCE;
        System.out.println(singleton_03 == singleton_031);

        Singleton_05 singleton_05 = Singleton_05.getInstance();
        Singleton_05 singleton_051 = Singleton_05.getInstance();
        System.out.println(singleton_05 == singleton_051);

    }
}
