package com.something.designPattern.decorator.example;

/**
 * Richie的通用装饰者
 * 包装Richie
 */
public class DecoratedRichie implements IRichie {

    private IRichie richie;

    public DecoratedRichie(IRichie richie) {
        this.richie = richie;
    }

    @Override
    public void listen() {
        richie.listen();
    }

    @Override
    public void speak() {
        richie.speak();
    }

    @Override
    public void read() {
        richie.read();
    }

    @Override
    public void write() {
        richie.write();
    }
}
