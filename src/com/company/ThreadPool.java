package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    /**
     * Objects, Variables, Components, ...
     */
    private static ExecutorService executor;

    /**
     * Initializes a new CachedThreadPool.
     */
    public static void init() {
        executor = Executors.newCachedThreadPool();
    }

    /**
     * This method initializes and then executes the executor
     */
    public static void execute(Runnable runnable) {
        if (executor == null)
            init();
        executor.execute(runnable);
    }
}
