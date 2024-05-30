package com.viniciusmdc.ExemploPatternSingleton.Thread;

public class ThreadExample2 extends BaseThread {

    public ThreadExample2() {}

    @Override
    public void run() {
        try {
            System.out.println("Iniciou T2");
            Thread.sleep(15000);
            System.out.println("Finalizou T2");
        } catch (InterruptedException e) {
            System.out.println("Interrompida T2");
        }
    }

}
