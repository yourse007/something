package com.something.designPattern.proxy.example.dynamicProxy.jdk.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 统一日志处理
 */
public class LogHandler implements InvocationHandler {

    private Object instance;

    public LogHandler(Object instance) {
        this.instance = instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("print some log information before doing " + method.getName() + "(" + Arrays.toString(args) + ")");

        Object result = method.invoke(instance, args);

        System.out.println("core service " + method.getName() + " finished.");

        return result;
    }

}
