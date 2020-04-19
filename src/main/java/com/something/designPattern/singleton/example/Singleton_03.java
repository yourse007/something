package com.something.designPattern.singleton.example;

/**
 * 单例模式 - 枚举式
 *
 * 枚举是java中一种特殊类型，它对外本身就没有构造方法，在类加载之后，它的实例变量就已经确定下来，天然适合作为单例模式的实现方式
 *
 * 注意：枚举无法继承，因为它本身已经继承了{@link java.lang.Enum}，所以如果单例类需要实现父类的方法，此种方式不适合
 */
public enum Singleton_03 {

    INSTANCE;

}
