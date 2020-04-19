package com.something.designPattern.proxy.example.dynamicProxy.cglib;

import com.something.designPattern.proxy.example.dynamicProxy.cglib.example.DaoService;
import com.something.designPattern.proxy.example.dynamicProxy.cglib.example.TransactionManager;
import net.sf.cglib.proxy.Enhancer;

/**
 * cglib动态代理
 * <p>
 * 在{@link com.something.designPattern.proxy.Description}中提到过，cglib动态代理是利用ASM技术操作底层的字节码，以此来为
 * 委托类动态地生成子类作为其代理类
 * <p>
 * 这里我们模拟通过代理方式对数据库进行事务操作
 *
 * @see Enhancer
 * @see net.sf.cglib.proxy.MethodInterceptor
 */
public class Description {

    public static void main(String[] args) throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DaoService.class);
        enhancer.setCallback(new TransactionManager());

        DaoService dao = (DaoService) enhancer.create();

        dao.add(5);
    }

}
