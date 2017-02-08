package com.bucket.jdk.thread;

public class ThreadWait {

    public static void main(String[] args) throws InterruptedException {
        Ticket ticket = new Ticket(10);
        MyTask task1 = new MyTask(ticket);
        MyTask2 task2 = new MyTask2(ticket);

        Thread t = new Thread(task1);
        Thread t2 = new Thread(task2);
        t.start();
        t2.start();

    }
}
