package com.something.designPattern.proxy.example.dynamicProxy.jdk;

import com.something.designPattern.proxy.example.dynamicProxy.jdk.example.LogHandler;
import com.something.designPattern.proxy.example.dynamicProxy.jdk.example.Service;
import com.something.designPattern.proxy.example.dynamicProxy.jdk.example.ServiceImpl;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 *
 * jdk动态代理模式是利用java中的反射原理来实现。这里模拟统一处理日志的情形
 *
 * 注意：这种方式要求被代理的类必须是接口的实现类，因为虚拟机需要知道代理类要实现哪些方法
 *
 * @see java.lang.reflect.Proxy
 * @see java.lang.reflect.InvocationHandler
 */
public class Description {


    public static void main(String[] args) {

        // 实际的服务提供者
        Service service = new ServiceImpl();

        // invocationHandler
        LogHandler handler = new LogHandler(service);

        Class clazz = service.getClass();

        // 生成代理对象
        Service proxyBean = (Service) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler);

        System.out.println("proxy bean : " + proxyBean.getClass().getName());

        // 调用服务方法
        String result = proxyBean.doService("argument");

        System.out.println("return value = " + result);

        proxyBean.doService2();

    }
}
