package com.example.mypackage;

import java.util.ArrayList;

public class TheConsumer implements Runnable{

    private ArrayList<String> data;
    String color;

    public TheConsumer(ArrayList<String> list, String color){
        this.data = list;
        this.color = color;
    }


    @Override
    public void run() {
        while (true){
            synchronized (data){
                if (data.isEmpty()){
                    continue;
                }
                if (data.get(0).equals("END OF FILE")){
                    break;
                }else {
                    System.out.println(color + "Removed by the Thread " + Thread.currentThread().getName() + " --- " +
                            data.remove(0));
                }
            }
        }
    }
}
