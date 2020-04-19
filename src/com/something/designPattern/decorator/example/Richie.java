package com.something.designPattern.decorator.example;

/**
 * 基本实现 实现Richie的各项基本能力
 */
public class Richie implements IRichie {
    @Override
    public void listen() {
        System.out.println("richie is listening.");
    }

    @Override
    public void speak() {
        System.out.println("richie is speaking.");
    }

    @Override
    public void read() {
        System.out.println("richie is reading.");
    }

    @Override
    public void write() {
        System.out.println("richie is writing.");
    }
}
