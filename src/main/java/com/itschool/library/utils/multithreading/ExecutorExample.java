package com.itschool.library.utils.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();
        Runnable tassk1 = () -> System.out.println(" Task1 executed in a single thread");
        Runnable tassk2 = () -> System.out.println(" Task2 executed in a single thread");

        executor.execute(tassk1);
        executor.execute(tassk2);
    }
}
