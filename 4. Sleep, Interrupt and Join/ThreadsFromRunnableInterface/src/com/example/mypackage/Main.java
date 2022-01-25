package com.example.mypackage;

public class Main {

    public static void main(String[] args) {
        Thread threadFromRI = new Thread(new ThreadFromRunnableInterface());
        threadFromRI.start();

        Thread threadFromRITwo = new Thread(new ThreadFromRunnableInterface(){
            @Override
            public void run() {
                try {
                    threadFromRI.join();
                    System.out.println("threadFromRI terminated with success");
                } catch (InterruptedException e) {
                    System.out.println("I got Interrupted - anonymously");
                }
                System.out.println("Hello developer!!! Anonymously --- Runnable");
            }
        });
        threadFromRITwo.start();

    }
}
