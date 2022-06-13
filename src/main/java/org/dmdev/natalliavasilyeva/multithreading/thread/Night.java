package org.dmdev.natalliavasilyeva.multithreading.thread;

import org.dmdev.natalliavasilyeva.multithreading.util.NightConst;
import org.dmdev.natalliavasilyeva.multithreading.util.ThreadUtil;


public class Night extends Thread {

    private int count = 1;
    private final Object lock = new Object();

    @Override
    public void run() {
            synchronized (lock) {
                while (!ThreadUtil.isInterruptNecessary.get()) {
                    try {
                        System.out.printf("----------------\nNight %s started\n", (count++));
                        lock.notifyAll();
                        lock.wait(NightConst.NIGHT_INTERVAL);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public Object getLock() {
        return lock;
    }
}