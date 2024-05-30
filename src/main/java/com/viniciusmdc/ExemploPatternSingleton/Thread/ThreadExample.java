package com.viniciusmdc.ExemploPatternSingleton.Thread;

public class ThreadExample  extends BaseThread {

    public ThreadExample() {}

    @Override
    public void run() {
        try {
            System.out.println("Iniciou T1");
            Thread.sleep(15000);
            System.out.println("Finalizou T1");
        } catch (InterruptedException e) {
            System.out.println("Interrompida T1");
        }
    }

}
