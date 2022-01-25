package com.example.mypackage;

public class Main {
    public static Object lock = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(new Demo(ThreadColor.ANSI_GREEN), "P10");
        Thread t2 = new Thread(new Demo(ThreadColor.ANSI_BLUE), "P8");
        Thread t3 = new Thread(new Demo(ThreadColor.ANSI_CYAN), "P5");
        Thread t4 = new Thread(new Demo(ThreadColor.ANSI_RED), "P4");
        Thread t5 = new Thread(new Demo(ThreadColor.ANSI_PURPLE), "P2");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(5);
        t4.setPriority(4);
        t5.setPriority(2);

        t4.start();
        t5.start();
        t3.start();
        t1.start();
        t2.start();
    }

    private static class Demo implements Runnable{
        private int value = 1;
        private String color;

        public Demo(String threadColor) {
            this.color = threadColor;
        }

        @Override
        public void run() {
            for (int i=0; i<20; i++){
                synchronized (lock){
                    System.out.println(color + " " + Thread.currentThread().getName() +" state: " +value++);
                }
            }
        }
    }
}
