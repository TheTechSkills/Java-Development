package com.example.mypackage;

import java.util.ArrayList;

public class TheProducer implements Runnable{
    private ArrayList<String> data;
    String color;

    public TheProducer(ArrayList<String> list, String color){
        this.data = list;
        this.color = color;
    }

    @Override
    public void run() {
        String [] letters ={"A", "B", "C", "D", "E"};
        for (String letter:letters){

            try {
                System.out.println(color + "Uploading " + letter);
                synchronized (data){
                    data.add(letter);
                }
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("Interrupted producer");
            }
        }
        System.out.println("Last moment");
        synchronized (data){
            data.add("END OF FILE");
        }
    }
}
