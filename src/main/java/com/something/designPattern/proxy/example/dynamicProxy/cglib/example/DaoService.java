package com.something.designPattern.proxy.example.dynamicProxy.cglib.example;

/**
 * 数据访问服务
 */
public class DaoService {

    /**
     * 插入一条记录
     * @param id
     */
    public void add(int id) throws Exception {
        System.out.println("dao start to insert id = " + id);
        Thread.sleep(1000);

        // 模拟数据库操作中发生异常，会触发事务回滚
         int i = 1 / 0;

        System.out.println("dao finished insert id = " + id);
    }
}
