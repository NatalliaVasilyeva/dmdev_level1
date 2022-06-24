package org.dmdev.natalliavasilyeva.regexp.workers;

import org.dmdev.natalliavasilyeva.regexp.model.Call;
import org.dmdev.natalliavasilyeva.regexp.model.Complaint;
import org.dmdev.natalliavasilyeva.regexp.mappers.CallMapper;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Dispatcher extends Thread {

    private final BlockingQueue<Complaint> complaints;
    private final BlockingQueue<Call> calls;

    public Dispatcher(String name, BlockingQueue<Complaint> complaints, BlockingQueue<Call> calls) {
        this.complaints = complaints;
        this.calls = calls;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Complaint complaint = complaints.take();
                TimeUnit.SECONDS.sleep(5);
                calls.put(CallMapper.fromComplaint(complaint));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}