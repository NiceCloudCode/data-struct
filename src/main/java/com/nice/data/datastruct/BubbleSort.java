package com.nice.data.datastruct;


/**
 * 冒泡排序Java代码实现
 * 原理：依次比较相邻的两个数，将小数放在前面，大数放在后面,第一次比较之后最大的放在最右边
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {7, 2, 3, 1, 9, 4, 8, 6, 5};
        int[] sortArr = sort(arr);
        for (int i : sortArr) {
            System.out.println(sortArr[i]);
        }

    }

    private static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp;
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}
