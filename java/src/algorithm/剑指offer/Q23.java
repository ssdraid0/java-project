package algorithm.剑指offer;

import data_structure.binarytree.BinaryTree;
import data_structure.binarytree.BinaryTreeNode;

/**
 * 面试题 23：从上往下打印二叉树 题目：从上往下打印二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 */
public class Q23
{

    public static void main(String[] args)
    {
        BinaryTreeNode root1 = new BinaryTreeNode();
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        BinaryTreeNode node5 = new BinaryTreeNode();
        BinaryTreeNode node6 = new BinaryTreeNode();
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;
        root1.value = 8;
        node1.value = 8;
        node2.value = 7;
        node3.value = 9;
        node4.value = 2;
        node5.value = 4;
        node6.value = 7;
        BinaryTree.printFromTopToBottom(root1);
    }
}
