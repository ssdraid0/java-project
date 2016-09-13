package algorithm.剑指offer;

import data_structure.binarytree.BinaryTree;
import data_structure.binarytree.BinaryTreeNode;

/**
 * 面试题 19：二叉树的镜像
 * <p>
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Q19
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
        BinaryTreeNode rootBinaryTreeNode = BinaryTree.mirror(root1);
        System.out.println(rootBinaryTreeNode.value);
    }

}
