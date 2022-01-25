package com.example.mypackage;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TheConsumer implements Runnable{
    private ArrayList<String> dataPack;
    private ReentrantLock reentrantLock;
    String color;

    public TheConsumer(ArrayList<String> dataPack, String color, ReentrantLock reentrantLock) {
        this.dataPack = dataPack;
        this.color = color;
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        while (true){
            //reentrantLock.lock();
            if (reentrantLock.tryLock()){
                try {
                    if (dataPack.isEmpty()){
                        //reentrantLock.unlock();
                        continue;
                    }
                    if (dataPack.get(0).equals("NO MORE DATA")){
                        //reentrantLock.unlock();
                        break;
                    }else {
                        System.out.println(color + "Removed by thread " + Thread.currentThread().getName() +
                                " -- " + dataPack.remove(0));
                    }
                }finally {
                    reentrantLock.unlock();
                }
            }


            //reentrantLock.unlock();
        }
    }
}
