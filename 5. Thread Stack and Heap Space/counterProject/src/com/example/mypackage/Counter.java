package com.example.mypackage;

public class Counter {
    int i;
    public synchronized void countNow(){
        for (i=25; i>0;i--){
            System.out.println(Thread.currentThread().getName()
                    + " i == " + i);
        }
    }
}
