package com.michealkz.tree;

import com.michealkz.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

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

    // 二叉树的前序遍历操作
    public void preorderTraversal() {
        preorderTraversal(root);
    }

    // 二叉树的前序遍历传入根节点进行遍历操作
    private void preorderTraversal(Node<E> node) {
        if (node == null) return;
        System.out.print(node.element + "\t");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    // 二叉树中序遍历
    public void middleOrderTraversal() {
        middleOrderTraversal(root);
    }

    // 二叉树中序遍历实现逻辑
    private void middleOrderTraversal(Node<E> node) {
        if (node == null) return;
        middleOrderTraversal(node.left);
        System.out.print(node.element + "\t");
        middleOrderTraversal(node.right);
    }

    // 二叉树后序遍历
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    // 二叉树后序遍历实现
    private void postOrderTraversal(Node<E> node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.element + "\t");
    }

    // 二叉树层序遍历
    public void levelOrderTraversal() {
        levelOrderTraversal(root);
    }

    // 二叉树层序遍历实现逻辑

    /**
     * 二叉树层序遍历很重要
     * 遍历思路：
     * - 1.定义队列存放节点
     * - 2.首先将根节点入队列
     * - 3.如果队列不为空，那么将队列顶部元素出队
     * - 4.输出根节点的值
     * - 5.判断根节点左右节点是否为空，如果不为空，那么将左右节点入队列，只要队列不为空就一直执行while循环
     *
     * @param root
     */
    private void levelOrderTraversal(Node<E> root) {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            System.out.print(node.element + "\t");

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

    }

    /**
     * 计算二叉树的高度
     * 思路： 借用层序遍历的方式计算二叉树的高度
     */
    public int height() {
        if (root == null) return 0;

        int height = 0;
        // 记录每一层的元素数量
        int levelSize = 1;
        Queue<Node<E>> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelSize--;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }


            if (levelSize == 0) {// 意味着即将访问下一层
                levelSize = queue.size();// 设置新的leveleSize为队列的长度
                height++;// 高度自增 1
            }
        }
        return height;
    }

    /**
     * 判断是否是完全二叉树
     * -  如果树为空，返回false
     * -  如果 node.left !=null && node.right !=null ,将node.left  node.right 顺序入队
     * -  如果node.left =null && node.right == null ，返回 false
     * -  如果node.left !=null && node.right==null, 或者node.left ==null && node.right==null,那么后面遍历的节点都应该为叶子节点，才是完全二叉树
     * -  否则返回 Flase
     * -  遍历结束
     */
    public boolean isCompleteBinarySearchTree() {
        if (root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        // 是否为叶子节点
        boolean leaf = false;

        //
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            // 如果该叶子节点本身自己判断不是叶子节点的话，说明这个不是连续的叶子节点，故不是完全二叉树，需要返回false
            if (leaf && !node.isLeaf()) return false;

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {// node.left == null && node.right != null
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else {// node.right == null
                leaf = true;
            }
        }
        return true;
    }

    /**
     * 下面是打印需要重写的四个方法
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
    public static class Node<E> {
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
