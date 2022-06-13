package org.dmdev.natalliavasilyeva.multithreading.thread;

import org.dmdev.natalliavasilyeva.multithreading.model.Race;
import org.dmdev.natalliavasilyeva.multithreading.util.ThreadUtil;

import java.util.List;

public class CrystalsChecker extends Thread {

    private final List<Race> races;

    private boolean stop;

    public CrystalsChecker(List<Race> races) {
        this.races = races;
    }


    @Override
    public void run() {
        while (!stop) {
            boolean result = races.stream().anyMatch(Race::isFull);
            if (result) {
                stop = true;
                break;
            }
        }
        ThreadUtil.isInterruptNecessary.set(true);
    }

}