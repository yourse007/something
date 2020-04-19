package com.something.designPattern.proxy.example.dynamicProxy.jdk.example;

/**
 * 服务实现类
 */
public class ServiceImpl implements Service {

    @Override
    public String doService(String arg) {
        System.out.println("do core service. arg = " + arg);
        return "success";
    }

    @Override
    public void doService2() {
        System.out.println("do core service2.");
    }

}
