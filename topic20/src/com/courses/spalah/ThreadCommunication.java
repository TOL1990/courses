package com.courses.spalah;

/**
 * @author Ievgen Tararaka
 */
public class ThreadCommunication {
    public static void main(String[] args) throws InterruptedException {
        waitNotify();
    }

    public static void waitNotify() throws InterruptedException {
        Object obj = new Object();
        Thread thread = new Thread(new WaitingWorker(obj), "worker#1");
        thread.start();

        Thread.sleep(1000);
        System.out.println("MAIN THREAD SLEEP FOR 1 SEC");

        synchronized (obj) {
            obj.notify();
            Thread.sleep(2000);
            System.out.println("SLEEP AFTER NOTIFY 2 SEC");
        }
    }
}

class Signal {
    private boolean workDone;

    public synchronized boolean isWorkDone() {
        return workDone;
    }

    public synchronized void setWorkDone(boolean workDone) {
        this.workDone = workDone;
    }
}

class SignalWorker implements Runnable {
    private Signal signal; // сигнал для общения между потоками

    @Override
    public void run() {
        while (!signal.isWorkDone()) {
            // ничего не делаем, но расходуем процессорное время =(
        }
    }
}

class WaitingWorker implements Runnable {
    private Object object;

    public WaitingWorker(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + " WAITING");
            try {
                Thread.sleep(10000);
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("DO MY WORK");
        }
    }
}