package com.algorithm.other.designPattern.decorator.example;

/**
 * 具备英文能力的Richie
 */
public class EnglishRichie extends DecoratedRichie {

    public EnglishRichie(IRichie richie) {
        super(richie);
    }

    @Override
    public void listen() {
        System.out.println("now richie can listen English.");
        super.listen();
    }

    @Override
    public void speak() {
        System.out.println("now richie can speak English.");
        super.speak();
    }

    @Override
    public void read() {
        System.out.println("now richie can read English.");
        super.read();
    }

    @Override
    public void write() {
        System.out.println("now richie can write English.");
        super.write();
    }
}
