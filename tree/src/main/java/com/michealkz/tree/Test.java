package com.michealkz.tree;

import java.util.LinkedList;
import java.util.Queue;

// import com.michealkz.tree.BinarySearchTree.Node

public class Test {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的层序遍历
     *
     */
    /**
    public static void levelIterator(BinarySearchTree.Node<String> root) {
        Queue<BinarySearchTree.Node<String>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinarySearchTree.Node node = queue.poll();
            System.out.println(queue.element());
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

    }
     */
}
