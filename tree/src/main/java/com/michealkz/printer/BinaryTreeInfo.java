package com.michealkz.printer;

/**
 * 二叉树信息 根节点 怎么去找左子树 怎么去找右子树 如何打印
 */
public interface BinaryTreeInfo {
    /**
     * who is the root node
     */
    Object root();

    /**
     * how to get the left child of the node
     */
    Object left(Object node);

    /**
     * how to get the right child of the node
     */
    Object right(Object node);

    /**
     * how to print the node
     */
    Object string(Object node);
}
