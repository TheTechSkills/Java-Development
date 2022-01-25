package com.example.mypackage;

public class Main {

    public static void main(String[] args) {
	    /*Class to be the boilerplate of our counter object (25-1)
	    Class to represent the thread where we're going to run our counter
	    Use two threads to run the same instance of our counter
	     */
        Counter counter = new Counter();
        CounterThread counterThreadOne = new CounterThread(counter);
        counterThreadOne.setName("Thread One (1) ");
        CounterThread counterThreadTwo = new CounterThread(counter);
        counterThreadTwo.setName("Thread Two (2) ");
        counterThreadOne.start();
        counterThreadTwo.start();
    }
}

