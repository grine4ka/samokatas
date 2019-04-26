package ru.bykov.javakatas;

public class CheckSynchronized {

    static class A {
        void set1() {
            synchronized (this) {
                System.out.println("set1 " + Thread.currentThread());
            }
        }
    }

    public static void main(String[] args) {
        final A a = new A();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                synchronized (a) {
                    a.set1();
                }
            }).start();
        }
    }
}
