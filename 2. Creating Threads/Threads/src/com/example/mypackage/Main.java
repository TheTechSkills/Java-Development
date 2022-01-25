package com.example.mypackage;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Developer!!! I am the Main Thread");
        //Create a subclass of the Tread class and override the run() method
        Thread subClassThread = new SubClassThread();
        subClassThread.start();
        System.out.println("I am here again my developer, The Main Thread");

        //Anonymous class
        new Thread(){
            public void run(){
                System.out.println("Hey developer!!! I am the thread from your anonymous class");
            }
        }.start();
    }
}
