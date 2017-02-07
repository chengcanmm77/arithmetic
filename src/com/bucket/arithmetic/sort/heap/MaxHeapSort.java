package com.bucket.arithmetic.sort.heap;

public class MaxHeapSort {

    private int[] data;

    public MaxHeapSort(int[] data) {
        this.data = data;
    }

    private void maxHeapify(int[] data, int i) {
        int left = this.left(i);
        int right = this.right(i);
        int max = i;
        if (left <= data.length && data[max - 1] < data[left - 1]) {
            max = left;
        }
        if (right <= data.length && data[max - 1] < data[right - 1]) {
            max = right;
        }

        if (max != i) {
            int temp = data[i - 1];
            data[i - 1] = data[max - 1];
            data[max - 1] = temp;
            maxHeapify(data, max);
        }
    }

    private void buildMaxHeap() {
        int loop = data.length / 2;
        for (; loop > 0; loop--) {
            maxHeapify(data, loop);
        }
    }

    public void sort() {
        buildMaxHeap();
        int loop = data.length - 1;
        for (; loop >= 0; loop--) {
            int temp = data[0];
            data[0] = data[loop];
            data[loop] = temp;
            maxHeapify(data, 1);
        }
    }

    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return 2 * i + 1;
    }

    public static void main(String[] args) {
        int[] a = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
        MaxHeapSort maxHeap = new MaxHeapSort(a);
        maxHeap.sort();
        for (int t : a) {
            System.out.print(t + ",");
        }
    }
}
