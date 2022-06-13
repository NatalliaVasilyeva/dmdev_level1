package org.dmdev.natalliavasilyeva.multithreading.util;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ThreadUtil {
    public static AtomicBoolean isInterruptNecessary = new AtomicBoolean(false);

    private ThreadUtil() {
    }

    public static void startThreads(List<Thread> threads) {
       threads.forEach(Thread::start);
    }

    public static void joinThreads(List<Thread> threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
    }
}