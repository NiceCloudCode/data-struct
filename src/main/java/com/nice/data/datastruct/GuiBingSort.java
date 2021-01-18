package com.nice.data.datastruct;

import java.util.Arrays;

/**
 * 归并排序实现
 */
public class GuiBingSort {
    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
        int tmp[] = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmp);
        System.out.println("归并排序后的数组是：" + Arrays.toString(arr));
    }

    /**
     * 分+合的方法
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            // 中间索引
            int mid = (left + right) / 2;
            // 向左递归分解
            mergeSort(arr, left, mid, temp);
            // 向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并的方法
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边有序序列的初始索引
     * @param tmp   中转的临时数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] tmp) {

        int i = left;   // 左边有序序列的初始索引
        int j = mid + 1;// 右边有序序列的初始索引
        int t = 0;      // 指向tmp数组的当前索引

        /**
         * 1.把左右两边【有序】的数据按照规则填充到tmp数组中
         * 直到左右两边的有序序列，有一边处理完毕为止
         */
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[t] = arr[i];
                t += 1;
                i += 1;
            } else {// 反之将右边有序序列的当前元素填充到tmp数组
                tmp[t] = arr[j];
                t+=1;
                j+=1;
            }
        }

        /**
         * 2.把有剩余数据的一边的数据依次全部填充到tmp中
         */
        while (i <= mid) {//左边有序序列还有剩余元素，全部填充到tmp中
            tmp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) {//右边有序序列还有剩余元素，全部填充到tmp中
            tmp[t] = arr[j];
            t += 1;
            j += 1;
        }

        /**
         * 3.将tmp数组的元素拷贝到原始数组中
         */
        t = 0;
        int tmpLeft = left;
        while (tmpLeft <= right) {
            arr[tmpLeft] = tmp[t];
            t += 1;
            tmpLeft += 1;
        }
    }
}
