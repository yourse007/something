package com.something.designPattern.proxy.example.staticProxy.example;

/**
 * 服务代理类
 */
public class ServiceProxy implements Service {

    private Service service;

    public ServiceProxy(Service service) {
        this.service = service;
    }

    @Override
    public void service() {
        System.out.println("do some validation to verify identity.");
        service.service();
        System.out.println("do some work after core service.");
    }

}
