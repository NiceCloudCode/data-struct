package com.nice.data.datastruct;

import java.util.ArrayList;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        // int[] arr = {7, 2, 3, 1, 9, 4, 8, 6, 5, 5, 3};
        flatten();
    }

    public static void findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
                if (count >= 2) {
                    set.add(nums[i]);
                }
            }
        }
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }

    public static void flatten() {
        int[][] arr = new int[][]{{4, 5, 6, 8}, {2, 3}, {1, 6, 9}};
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                list.add(arr[i][j]);
            }
        }

        for (Integer ele : list) {
            System.out.println(ele);
        }
    }
}
