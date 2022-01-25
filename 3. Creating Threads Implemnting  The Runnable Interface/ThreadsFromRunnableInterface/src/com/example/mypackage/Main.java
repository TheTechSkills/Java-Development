package com.example.mypackage;

public class Main {

    public static void main(String[] args) {
       /* Thread threadFromRI = new Thread(new ThreadFromRunnableInterface());
        threadFromRI.start();
*/
        Thread threadFromRI = new Thread(new ThreadFromRunnableInterface(){
            @Override
            public void run() {
                System.out.println("Hello developer!!! Anonymously --- Runnable");
            }
        });
        threadFromRI.start();
    }
}
