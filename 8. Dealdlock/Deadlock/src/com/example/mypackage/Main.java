package com.example.mypackage;

public class Main {
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        t1.start();
        t2.start();
    }

    private static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (Lock1) {
                System.out.println("Thread 1 has the Lock1");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 is waiting for the Lock 2");
                synchronized (Lock2){
                    System.out.println("Thread 1 has both Lock1 and Lock2");
                }
            }
            System.out.println("Thread 1 has done all and released Lock 1 and Lock 2");

        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (Lock1){
                System.out.println("Thread 2 has the Lock1");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2 is waiting for the Lock 2");
                synchronized (Lock2){
                    System.out.println("Thread 2 has both Lock1 and Lock2");
                }
            }
            System.out.println("Thread 2 has done all and released Lock 1 and Lock 2");
        }
    }

}
