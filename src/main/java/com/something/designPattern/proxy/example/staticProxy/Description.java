package com.something.designPattern.proxy.example.staticProxy;

import com.something.designPattern.proxy.example.staticProxy.example.*;

/**
 * 静态代理模式demo
 *
 * 这里模拟一个对外提供服务的接口{@link Service}, 服务的具体逻辑在其实现类{@link ServiceImpl}中；如果service服务只提供给特定的
 * 角色权限，那我们可以利用代理模式，在提供服务之前做一些身份的验证工作，正如例子中的{@link ServiceProxy}代理类。
 *
 */
public class Description {

    public static void main(String[] args) {

        Service service = new ServiceProxy(new ServiceImpl());
        service.service();

    }
}
