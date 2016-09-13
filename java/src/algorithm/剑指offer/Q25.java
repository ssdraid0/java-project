package algorithm.剑指offer;

import data_structure.binarytree.BinaryTree;
import data_structure.binarytree.BinaryTreeNode;

/**
 * 面试题 25：二叉树中和为某一值的路径 
 * <p>
 * 题目：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
 * 有路径。从树的根节点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Q25
{
    public static void main(String[] args)
    {
        BinaryTreeNode root1 = new BinaryTreeNode();
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        root1.value = 10;
        node1.value = 5;
        node2.value = 12;
        node3.value = 4;
        node4.value = 7;
        BinaryTree.findPath(root1, 22);
    }

}
