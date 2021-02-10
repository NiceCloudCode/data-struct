package com.michealkz.single;

import com.michealkz.list.List;

import com.michealkz.list.LinkedList;

/**
 * 采用双向链表实现队列
 * 队列只能从头部出队，只能从尾部入队
 */
public class Queue<E> {
    private List<E> list = new LinkedList<E>();

    // 获取队列的长度
    public int size() {
        return list.size();
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // 清空队列
    public void clear() {
        list.clear();
    }

    // 入队只能够从队列尾部入队
    public void enQueue(E element) {
        list.add(element);
    }

    // 出队只能从队列头部出队
    public E deQueue() {
        return list.remove(0);
    }

    // 获取队列头部元素
    public E front() {
        return list.get(0);
    }
}
