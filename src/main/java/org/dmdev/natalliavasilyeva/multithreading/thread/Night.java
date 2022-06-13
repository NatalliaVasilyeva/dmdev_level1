package org.dmdev.natalliavasilyeva.multithreading.thread;

import org.dmdev.natalliavasilyeva.multithreading.util.NightConst;
import org.dmdev.natalliavasilyeva.multithreading.util.ThreadUtil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Night extends Thread {

    private int count = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    @Override
    public void run() {
        lock.lock();
        try {
            while (!ThreadUtil.isInterruptNecessary.get()) {
                System.out.printf("----------------\nNight %s started\n", (count++));
                condition.signalAll();
                condition.await(NightConst.NIGHT_INTERVAL, TimeUnit.MILLISECONDS);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            condition.signalAll();
            lock.unlock();
        }
    }

    public Lock getLock() {
        return lock;
    }

    public Condition getCondition() {
        return condition;
    }
}