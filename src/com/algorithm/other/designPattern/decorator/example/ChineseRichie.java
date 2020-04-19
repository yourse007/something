package com.algorithm.other.designPattern.decorator.example;

/**
 * 具备中文能力的Richie
 */
public class ChineseRichie extends DecoratedRichie {

    public ChineseRichie(IRichie richie) {
        super(richie);
    }

    @Override
    public void listen() {
        System.out.println("now richie can listen Chinese.");
        super.listen();
    }

    @Override
    public void speak() {
        System.out.println("now richie can speak Chinese.");
        super.speak();
    }

    @Override
    public void read() {
        System.out.println("now richie can read Chinese.");
        super.read();
    }

    @Override
    public void write() {
        System.out.println("now richie can write Chinese.");
        super.write();
    }
}
