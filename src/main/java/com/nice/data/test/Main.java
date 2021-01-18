package com.nice.data.test;


import java.util.Scanner;

/**
 * 采用二分查找的方式实现需求
 */
public class Main {
    public static int count = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int fakes = in.nextInt();
        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[i] = i + 1;
        }
        recursionBinarySearch(arr, fakes, 0, total - 1);
        System.out.println(count);
    }

    /**
     * 二分查找的方法
     *
     * @param arr
     * @param key
     * @param start
     * @param end
     * @return
     */
    private static int recursionBinarySearch(int[] arr, int key, int start, int end) {
        count += 1;
        if ((end + 1) % 2 == 1 && arr[end] == key) {
            return count;
        }
        if (key < arr[start] || key > arr[end] || start > end) {
            return -1;
        }

        if (arr[end] == key){
            count++;
            return count;
        }

        int middle = (start + end) / 2;
        if (key > arr[middle]) {
            return recursionBinarySearch(arr, key, middle + 1, end);
        } else if (key <= arr[middle]) {
            return recursionBinarySearch(arr, key, start, middle - 1);
        } else {
            return -1;
        }
    }
}
