package com.michealkz.doublelist;

/**
 * 双向链表LinkedList
 */
public class LinkedList<E> extends AbstractList<E> {
    // 指向头节点
    private Node<E> first;
    // 指向尾节点
    private Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    public E get(int index) {
        return node(index).element;
    }

    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    /**
     * 双向链表的添加操作
     * 重点判断添加的index 位于头节点和尾节点的时候
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size) {// 链表的最后面进行添加
            Node<E> oldNode = last;
            last = new Node<E>(oldNode, element, null);
            if (oldNode == null) {
                // 表示这个是链表添加的第一个元素
                first = last;
            } else {
                oldNode.next = last;
            }
        } else {
            Node<E> next = node(index);// 获取原来Index位置的元素
            Node<E> prev = next.prev; // 原来index位置的前一个元素
            Node<E> node = new Node<E>(prev, element, next); // 创建新的节点
            if (prev == null) {
                // 说明是添加到 index == 0 位置
                first = node;
            } else {
                prev.next = node;
            }
        }
    }

    public E remove(int index) {
        rangeCheck(index);
        Node<E> oldNode = node(index);
        Node<E> prev = oldNode.prev;
        Node<E> next = oldNode.next;

        if (prev == null) {
            // 说明移除的元素是首个元素
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {// 说明移除的元素是链表最后一个元素
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return oldNode.element;
    }

    public int indexOf(E element) {
        if (element == null) { // element 分为 null 和 值的判断
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置对应的节点对象
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        // 由于是双向链表，故而用中间元素作为判断，这里用位运算实现1/2的效果
        if (index < (size >> 1)) {// 如果 index 小于 size/2 ，那么从头节点开始找
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {// 如果index 大于 size/2 ,那么从尾节点开始找
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

}
