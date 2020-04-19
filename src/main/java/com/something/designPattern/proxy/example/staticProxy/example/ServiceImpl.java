package com.something.designPattern.proxy.example.staticProxy.example;

/**
 * 服务实现类（即提供核心服务逻辑的类）
 */
public class ServiceImpl implements Service {

    @Override
    public void service() {
        System.out.println("providing service.");
    }

}
