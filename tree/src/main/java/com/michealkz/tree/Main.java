package com.michealkz.tree;

import com.michealkz.Person;
import com.michealkz.file.Files;
import com.michealkz.printer.BinaryTrees;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        testTraversal();
    }

    // 二叉树的遍历操作
    public static void testTraversal() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);
        System.out.println("***********");
        System.out.println();
        // bst.middleOrderTraversal(); //  中序遍历的结果就是排好序的二叉搜索树
        // bst.postOrderTraversal();   // 后序遍历
        // bst.preorderTraversal();    // 前序遍历
        bst.levelOrderTraversal();  // 层序遍历

        System.out.println();
        System.out.println("height is : "+bst.height());
    }


    /**
     * 测试用户自定义Bean 的比较方法
     */
    public static void testUDBeanCompare() {
        BinarySearchTree<Person> bst = new BinarySearchTree<>();
        bst.add(new Person(10, "jack"));
        bst.add(new Person(12, "rose"));
        bst.add(new Person(6, "jim"));

        bst.add(new Person(8, "michael1"));
        bst.add(new Person(11, "michael2"));
        bst.add(new Person(13, "michael3"));
        bst.add(new Person(5, "michael4"));

        BinaryTrees.println(bst);
    }

    /**
     * 写数据到文件中
     */
    public static void writeTreeToFile() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < 40; i++) {
            bst.add((int) (Math.random() * 100));
        }
        System.out.println();
        BinaryTrees.println(bst);
        // String str = BinaryTrees.printString(bst);
        // str += "\n";
        // Files.writeToFile("F:/1.txt", str, true);
    }

    /**
     * 测试二叉树的添加并整合compare功能，实现自定义的排序
     */
    public static void testAddWithCompare() {
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };
        BinarySearchTree<Person> bst2 = new BinarySearchTree<Person>(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        for (int i = 0; i < data.length; i++) {
            bst2.add(new Person(data[i]));
        }
        BinaryTrees.println(bst2);

    }

    public static void testAdd() {
        // 第一个添加的元素为二叉树的根节点
        Integer data[] = new Integer[]{8, 4, 9, 2, 5, 7, 11, 3, 12, 1};
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
    }


}
