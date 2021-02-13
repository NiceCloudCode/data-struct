package com.michealkz.tree;

import com.michealkz.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * 二叉搜索树继承自BinaryTreeInfo 实现其中的方法以便进行打印
 *
 * @param <E>
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public void add(E element) {
        elementNotNullCheck(element);

        // 添加第一个节点
        if (root == null) {
            root = new Node<E>(element, null);
            size++;
            return;
        }

        // 添加的不是第一个节点 则找到父节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        do {
            /*
             * 根据compare的返回值正负或者相等来判断是左子树还是右子树还是相等
             */
            cmp = compare(element, node.element);
            // 将节点保存下来作为查找下一个的父节点
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else { // 相等
                node.element = element;
                return;
            }
        } while (node != null);

        // 看看插入到父节点的哪个位置
        Node<E> newNode = new Node<E>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    /*
     * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }


    /**
     * 下面是打印需要重写的四个方法
     * <p>
     * 根节点
     */
    @Override
    public Object root() {
        return root;
    }

    // 左树的寻找方式
    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    // 右树的寻找方式
    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    // 打印方式
    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>) node;
        // 获取父节点保存下来并打印
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        return myNode.element;
    }

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /**
     * 二叉树的 Node节点 对象
     */
    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }
}
