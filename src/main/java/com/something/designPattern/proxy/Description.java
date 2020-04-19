package com.something.designPattern.proxy;

/**
 * 代理模式
 *
 * 代理模式用于增强核心服务逻辑，在真正的核心逻辑执行的前后，增加一些辅助的处理工作。
 * 一般地，我们可以将实现类的共性的处理步骤提取出来，通过代理类进行统一处理，便于统一的维护修改等。
 * 另外，我们也可以将一些与业务无关的操作放到代理逻辑中，达到与业务逻辑解耦的效果。
 *
 * 通常地，我们可以把代理模式分为静态代理和动态代理两种方式。
 *
 * 静态代理指的是在代码编写阶段，我们为真正的服务提供者(我们称为委托方)实现了对应的代理方，一般是通过代理类中持有委托类的方式，
 * 并将代理类实现与委托类相同的接口，这种思想类似于装饰者模式。
 * 例子：example包下的静态代理demo {@link com.something.designPattern.proxy.example.staticProxy.Description}
 *
 * 由于静态代理在编译期就已经确定了委托类和代理类，后续如果添加或者修改接口和实现的话，代理类和委托类都需要相应地修改，
 * 所以不利于后续的扩展，依据设计模式的开闭原则，进而衍生出动态代理模式。
 *
 * 动态代理是在JVM运行时期动态生成，而不是在编译期能够确定。这里介绍两种动态代理的实现方式：jdk的动态代理 和 cglib动态代理。
 * jdk动态代理是通过java的反射技术为委托类生成对应的代理类，实现的是统一接口，可以看作静态代理的动态模式。
 * cglib动态代理是利用ASM来操作字节码生成一个委托类的子类，覆写委托类的方法，从而将增强的逻辑织入核心逻辑中。
 * jdk动态代理的例子：{@link com.something.designPattern.proxy.example.dynamicProxy.jdk.Description}
 * cglib动态代理的例子：{@link com.something.designPattern.proxy.example.dynamicProxy.cglib.Description}
 *
 * 优缺点比较：
 * 静态代理的方式正如上面所述，在编译器确定了代理类和委托类，所以运行效率会比动态代理高一些，然而代价就是代码非常冗余，不便于
 * 后期的扩展和修改；
 * 动态代理的方式正好相反，很少的代码就能够提取出很多共性的东西，简洁且易维护，但是由于在JVM运行时期动态生成代理类，所以会影响运行效率。
 * 具体使用时，可以视当前情况而定，如果需要被代理的对象比较固定且不太繁多，可以考虑静态代理的方式。
 *
 *
 * 在很多开源框架中都可看到代理模式的身影。例如大名鼎鼎的spring framework，spring中的AOP（面向切面编程）就是通过动态代理技术来实现的，
 * 在spring应用运行时，它集成了jdk和cglib两种方式的动态代理，具体使用哪种方式视委托类而定：若委托类是接口的实现类，则使用jdk动态代理方式，
 * 反之，若委托类并不是接口的实现类，则利用cglib动态代理的方式为其生成子类。
 *
 * @see com.something.designPattern.proxy.example.staticProxy.Description
 * @see com.something.designPattern.proxy.example.dynamicProxy.jdk.Description
 * @see com.something.designPattern.proxy.example.dynamicProxy.cglib.Description
 */
public class Description {


}
