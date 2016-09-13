package algorithm.剑指offer;

import data_structure.binarytree.BinaryTree;

/**
 * 面试题 6：重建二叉树 题目描述：输入二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设前
 * 序遍历和中序遍历结果中都不包含重复的数字，例如输入的前序遍历序列
 * {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}重建出如图所示的二叉 树。
 */
public class Q06
{

    public static void main(String[] args)
    {
        int[] preSort =
        { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] inSort =
        { 4, 7, 2, 1, 5, 3, 8, 6 };
        try
        {
            BinaryTree.construct(preSort, inSort);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
