package com.bucket.jdk.thread;

public class Ticket {

    private int num;

    public Ticket(int num) {
        this.num = num;
    }

    public void saleTicket() {
        this.num = num - 1;
    }

    @Override
    public String toString() {
        return "Ticket [num=" + num + "]";
    }

}
