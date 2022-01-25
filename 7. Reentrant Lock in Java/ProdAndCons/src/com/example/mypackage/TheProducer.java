package com.example.mypackage;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TheProducer implements Runnable {
    private ArrayList<String> dataPack;
    private ReentrantLock reentrantLock;
    String color;

    public TheProducer(ArrayList<String> dataPack, String color, ReentrantLock reentrantLock) {
        this.dataPack = dataPack;
        this.color = color;
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        String[] valuesToAdd = {"A", "B", "C", "D", "E", "F"};
        for (String stringToAdd:valuesToAdd){
            try {
                System.out.println(color + "We're adding: " + stringToAdd);
                //reentrantLock.lock();
                reentrantLock.lock();
                try {
                    dataPack.add(stringToAdd);
                }finally {
                    reentrantLock.unlock();
                }

                //reentrantLock.unlock();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Producer");
            }
        }
        System.out.println("Adding the last one");

            reentrantLock.lock();
            try {
                dataPack.add("NO MORE DATA");
            }finally {
                reentrantLock.unlock();
            }

            //reentrantLock.unlock();
    }
}
