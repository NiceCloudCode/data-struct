package com.michealkz;

public class Main {
    public static void main(String[] args) {
        final int n = 45;
        Times.test("fib1", new Times.Task() {
            public void execute() {
                fib1(n);
            }
        });

        Times.test("fib2", new Times.Task() {
            public void execute() {
                fib2(n);
            }
        });
    }
    /* 0 1 2 3 4 5
     * 0 1 1 2 3 5 8 13 ....
     */

    // O(2^n)
    public static int fib1(int n) {
        if (n <= 1) return n;
        return fib1(n - 1) + fib1(n - 2);
    }

    // O(n)
    public static int fib2(int n) {
        if (n <= 1) return n;

        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
}
