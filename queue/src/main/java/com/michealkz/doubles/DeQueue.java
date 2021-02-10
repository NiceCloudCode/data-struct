package com.michealkz.doubles;

import com.michealkz.list.LinkedList;
import com.michealkz.list.List;

/**
 * 双向队列实现
 * 双端队列是能够在头尾添加删除的队列
 * <p>
 * int size(); // 元素的数量
 * ◼ boolean isEmpty(); // 是否为空
 * ◼ void clear(); // 清空
 * ◼ void enQueueRear(E element); // 从队尾入队
 * ◼ E deQueueFront(); // 从队头出队
 * ◼ void enQueueFront(E element); // 从队头入队
 * ◼ E deQueueRear(); // 从队尾出队
 * ◼ E front(); // 获取队列的头元素
 * ◼ E rear(); // 获取队列的尾元素
 */
public class DeQueue<E> {
    private List<E> list = new LinkedList<E>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    // 在对垒头部添加元素
    public void enQueueFront(E element) {
        list.add(0, element);
    }

    // 在队列尾部添加元素
    public void enQueueRear(E element) {
        list.add(element);
    }

    // 在队列头部弹出元素
    public E deQueueFront() {
        return list.remove(0);
    }

    // 在队列尾部弹出元素
    public E deQueueRear() {
        return list.remove(list.size() - 1);
    }

    // 获取队列头部的元素
    public E front() {
        return list.get(0);
    }

    // 获取队列尾部的元素
    public E rear() {
        return list.get(list.size() - 1);
    }
}
