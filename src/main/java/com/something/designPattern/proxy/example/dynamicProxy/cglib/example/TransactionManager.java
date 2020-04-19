package com.something.designPattern.proxy.example.dynamicProxy.cglib.example;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 事务管理
 */
public class TransactionManager implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println("before execute method : " + method.getName() + ", arg = " + Arrays.toString(args));
        System.out.println("- - - - 》 transaction begin.");
        Object result = null;

        try {
            result = methodProxy.invokeSuper(o, args);
        } catch (Exception e) {
            System.err.println("- - - - 》 error. transaction rollback.");
            return false;
        }
        System.out.println("- - - - 》 transaction commit.");
        System.out.println("after execute method : " + method.getName());

        return result;
    }
}
