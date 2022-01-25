package com.example.mypackage;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> pack = new ArrayList<>();
        ReentrantLock reentrantLock = new ReentrantLock();
        TheProducer theProducer = new TheProducer(pack, ThreadColors.ANSI_GREEN, reentrantLock);
        TheConsumer firstConsumer = new TheConsumer(pack,ThreadColors.ANSI_PURPLE, reentrantLock);
        TheConsumer secondConsumer = new TheConsumer(pack, ThreadColors.ANSI_CYAN, reentrantLock);

        Thread firstThread = new Thread(firstConsumer);
        firstThread.setName("Thread (1)");
        Thread secondThread = new Thread(secondConsumer);
        secondThread.setName("Thread (2)");
        new Thread(theProducer).start();
        firstThread.start();
        secondThread.start();
    }
}
