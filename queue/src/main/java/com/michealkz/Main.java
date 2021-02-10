package com.michealkz;

import com.michealkz.doubles.DeQueue;
import com.michealkz.single.Queue;

import java.util.Deque;

/**
 * 队列测试主类
 */
public class Main {
    public static void main(String[] args) {
        doubleQueueTest();
    }

    private static void doubleQueueTest() {
        DeQueue<Integer> queue = new DeQueue<Integer>();
        queue.enQueueFront(11);
        queue.enQueueFront(22);
        queue.enQueueRear(33);
        queue.enQueueRear(44);
        queue.enQueueFront(55);

        /* 尾  44  33   11  22  55头 */

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueueRear());
        }
    }

    private static void testSingleQueue() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enQueue(11);
        queue.enQueue(22);
        queue.enQueue(33);
        queue.enQueue(44);

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }
}
