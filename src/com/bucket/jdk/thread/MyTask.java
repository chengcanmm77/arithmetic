package com.bucket.jdk.thread;

public class MyTask implements Runnable {

    private Ticket ticket;

    public MyTask(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "==== wait");
        try {
            synchronized (ticket) {
                ticket.wait();
                System.out.println(threadName + "=== begin");
                ticket.saleTicket();
                System.out.println(threadName + "ticket sale==" + ticket);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
