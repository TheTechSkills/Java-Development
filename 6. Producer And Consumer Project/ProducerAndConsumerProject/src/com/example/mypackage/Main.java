package com.example.mypackage;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        TheProducer  theProducer = new TheProducer(list,ThreadColors.ANSI_BLUE);
        TheConsumer theConsumer = new TheConsumer(list, ThreadColors.ANSI_GREEN);
        TheConsumer theLastConsumer = new TheConsumer(list, ThreadColors.ANSI_RED);

        Thread threadOne = new Thread(theConsumer);
        threadOne.setName("Thread (1)");

        Thread threadTwo = new Thread(theLastConsumer);
        threadTwo.setName("Thread (2)");

        new Thread(theProducer).start();
        threadOne.start();
        threadTwo.start();

    }
}
