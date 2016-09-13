package algorithm.剑指offer;

import data_structure.binarytree.BinaryTree;
import data_structure.binarytree.BinaryTreeNode;

/**
 * 面试题 18：树的子结构<br>
 *  题目：输入两颗二叉树 A 和 B，判断 B 是不是 A 的子结构。<br>
 */
public class Q18
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
        BinaryTreeNode root2 = new BinaryTreeNode();
        BinaryTreeNode a = new BinaryTreeNode();
        BinaryTreeNode b = new BinaryTreeNode();
        root2.left = a;
        root2.right = b;
        root2.value = 8;
        a.value = 9;
        b.value = 2;
        System.out.println(BinaryTree.hasSubTree(root1, root2));
    }
}
