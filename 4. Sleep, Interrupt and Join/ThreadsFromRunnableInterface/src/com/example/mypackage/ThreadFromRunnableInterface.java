package com.example.mypackage;

public class ThreadFromRunnableInterface implements Runnable{
    @Override
    public void run() {
        System.out.println("I am from The Runnable");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("I got Interrupted");
            return;
        }
        System.out.println("Hello developer!!! " +
                "This is from the overwritten run() from the Runnable implementation");
        System.out.println("5s passed successfully");
    }
}
