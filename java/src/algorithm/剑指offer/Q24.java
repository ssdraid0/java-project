package algorithm.剑指offer;

import data_structure.binarytree.BinarySearchTree;

/**
 * 面试题 24：二叉搜索树的后序遍历序列
 * <p>
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。 是则返回true，否则返回false。
 */
public class Q24
{
    public static void main(String[] args)
    {
        //int[] a ={ 5, 7, 6, 9, 11, 10, 8 };
        //int[] a ={7,4,6,5};
        int[] a ={7,8,6,5};
        System.out.println(BinarySearchTree.isBST(a));
    }

}
