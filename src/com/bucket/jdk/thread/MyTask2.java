package com.bucket.jdk.thread;

public class MyTask2 implements Runnable {

    private Ticket ticket;

    public MyTask2(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        synchronized (ticket) {
            ticket.saleTicket();
            ticket.notifyAll();
            System.out.println(threadName + "ticket sale==" + ticket);
        }
    }

}
