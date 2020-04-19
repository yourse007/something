package com.something.designPattern.decorator;

import com.something.designPattern.decorator.example.EnglishRichie;
import com.something.designPattern.decorator.example.ChineseRichie;
import com.something.designPattern.decorator.example.IRichie;
import com.something.designPattern.decorator.example.Richie;

import java.io.*;

/**
 * 装饰者模式 & 包装模式
 *
 * 装饰者模式用于对调用者提供多种多样的组合功能，这些功能可以任由调用者灵活组装拆卸，并且实现细节对调用者透明化。
 *
 * 场景举例：
 * 在jdk的I/O类库中，提供给我们多种不同功能的
 * 这些类都以{@link InputStream}为基本接口衍生出不同读取方式. 当然，这些类只是实现了基本的功能。
 *
 * 而众所周知的是，我们在实际使用的时候，还有类如{@link BufferedInputStream}这种具备缓存能力的I/O流，那他们又是如何实现的呢？
 * 事实上，这些具备额外能力的I/O流就是今天的主角 -- 装饰者。
 *
 * 实现方式：
 * 翻看源码就可以发现，其实答案就在{@link BufferedInputStream}的父类{@link FilterInputStream}，该类同样是InputStream
 * 接口的实现类，只不过在{@link FilterInputStream}中持有一个{@link FileInputStream}的基本实现类，这样我们就可以在真正执行
 * 基本I/O操作的前后，对基本功能进行增强或定制处理，而这些增强和特殊处理就是通过{@link FileInputStream}的子类来实现，比如具备缓存功能
 * 的子类{@link BufferedInputStream}
 *
 * 例子：
 * example包下提供了一个demo，实现了多种功能的Richie以供我们选择，我们可以灵活搭配来组装最合适的功能。
 */
public class Description {


    public static void main(String[] args) {
        // 我想让richie用中文来听说读写
        ChineseRichie chineseRichie = new ChineseRichie(new Richie());
        chineseRichie.listen();
        chineseRichie.speak();
        chineseRichie.read();
        chineseRichie.write();


        System.out.println("----------------------------------------");
        // 我想让richie用英语来听说读写
        EnglishRichie englishRichie = new EnglishRichie(new Richie());
        englishRichie.listen();
        englishRichie.speak();
        englishRichie.read();
        englishRichie.write();

        System.out.println("----------------------------------------");
        // 我想让richie具备双语能力
        IRichie richie = new EnglishRichie(new ChineseRichie(new Richie()));
        richie.listen();
        richie.speak();
        richie.read();
        richie.write();
    }

}
