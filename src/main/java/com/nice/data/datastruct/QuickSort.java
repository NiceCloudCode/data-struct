package com.nice.data.datastruct;

/**
 * Java 实现快速排序
 * 假设我们对数组{7, 1, 3, 5, 13, 9, 3, 6, 11}进行快速排序。
 * 首先在这个序列中找一个数作为基准数，为了方便可以取第一个数。
 * 遍历数组，设置两个指针，一个从左往右找比基准数大的，另一个从右往左找比基准数小的，找到之后停止指针移动，左右两边都停止移动时候，
 * 交换指针两侧的值，这样寻找，当指针重合的时候，将此处的值与基准数交换位置，此时基准数左边的数都小于基准数，基准数右边的都大于基准数
 * 然后依次对基准数两边进行相同的操作即可。
 * 此时得到类似于这种排序的数组{3, 1, 3, 5, 6, 7, 9, 13, 11}。
 * 在初始状态下7是第一个位置，现在需要把7挪到中间的某个位置k，也即k位置是两边数的分界点。
 * 那如何做到把小于和大于基准数7的值分别放置于两边呢，我们采用双指针法，从数组的两端分别进行比对。
 * 先从最右位置往左开始找直到找到一个小于基准数的值，记录下该值的位置（记作 i）。
 * 再从最左位置往右找直到找到一个大于基准数的值，记录下该值的位置（记作 j）。
 * 如果位置i<j，则交换i和j两个位置上的值，然后继续从(j-1)的位置往前和(i+1)的位置往后重复上面比对基准数然后交换的步骤。
 * 如果执行到i==j，表示本次比对已经结束，将最后i的位置的值与基准数做交换，此时基准数就找到了临界点的位置k，位置k两边的数组都比当前位置k上的基准值或都更小或都更大。
 * 上一次的基准值7已经把数组分为了两半，基准值7算是已归位（找到排序后的位置）。
 * 通过相同的排序思想，分别对7两边的数组进行快速排序，左边对[left, k-1]子数组排序，右边则是[k+1, right]子数组排序。
 * 利用递归算法，对分治后的子数组进行排序。
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 2, 3, 1, 9, 4, 8, 6, 5, 0};
        quickSort2(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        int i, j, temp, t;
        if (left > right) {
            return;
        }
        i = left;
        j = right;

        //temp就是基准位，选取最左边的为基准位
        temp = arr[left];

        while (i < j) {
            //先看右边，依次往左递减，比基准大就继续往左找
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增，比基准小就继续往右找
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[left] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, left, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, right);
    }

    /**
     * 快速排序练习1
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort2(int[] arr, int left, int right) {
        int i, j, tmp, t;
        i = left;
        j = right;
        if (left > right) {
            return;
        }
        tmp = arr[left];
        while (i < j) {
            while (tmp <= arr[j] && i < j) {
                j--;
            }
            while (tmp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[left] = arr[i];
        arr[i] = tmp;

        //递归调用左半数组
        quickSort2(arr, left, j - 1);
        //递归调用右半数组
        quickSort2(arr, j + 1, right);
    }
}
