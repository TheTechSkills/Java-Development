package com.example.mypackage;

public class ThreadFromRunnableInterface implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello developer!!! This is from the overwritten run() from the Runnable implementation");
    }
}
