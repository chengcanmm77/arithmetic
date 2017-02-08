package com.bucket.arithmetic.sort.quick;

/**
 * 快速排序算法
 * 1、思路
 *   设置一个标准值，每次递归以这个标准值分割成两个数组，一个是比该标准值大的数组，一个是比该标准值小的数组
 * 
 * @author bucket
 */
public class QuickSort {

    private int data[];

    public QuickSort(int[] data) {
        this.data = data;
    }

    public void sort() {
        sort(this.data, 0, this.data.length - 1);
    }

    public QuickSort() {

    }

    public void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private void sort(int[] data, int start, int end) {
        if (start < end) {
            int q = partition(data, start, end);
            sort(data, start, q - 1);
            sort(data, q + 1, end);
        }
    }

    /**
     * 比较疑惑的地方是 i,j;
     * i是用来保存比x(标准值小的数),j是用来搜索比x小的数，所以每当遇到比x小的数就交换到 i+1上面
     */
    private int partition(int[] data, int start, int end) {
        int x = data[end];
        int i = start - 1;
        int j = start;
        for (; j <= end - 1; j++) {
            if (data[j] <= x) {
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i + 1, end);
        return i + 1;
    }

    private void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
        quickSort.sort(a);
        for (int t : a) {
            System.out.print(t + ",");
        }
    }
}
