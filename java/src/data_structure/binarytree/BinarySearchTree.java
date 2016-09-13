package data_structure.binarytree;

import java.util.Arrays;

/**
 * 1.什么是二叉搜索树？<br>
 * 左结点都比根结点小，右结点都比根结点大。<br>
 */
public class BinarySearchTree
{
    /**
     * 判断数组是不是某二叉搜索树的后序遍历
     * 
     * @param sequence
     * @return
     */
    public static boolean isBST(int[] sequence)
    {
        // 1.容错性
        if (sequence == null || sequence.length <= 0)
            return false;

        // 2.先要找到序列的分界点,此时因为对左子树进行了遍历所以也相当于对左子树进行了判断
        int i; // 分界点
        for (i = 0; i < sequence.length - 1; i++)
        {
            if (sequence[i] > sequence[sequence.length - 1])
                break;
        }
        // 3.对序列的右子树进行判断
        for (int j = i; j < sequence.length - 1; j++)
        {
            if (sequence[j] < sequence[sequence.length - 1])
                return false;
        }
        // 4.当左右子树都满足的时候就要进行递归
        if (i >= 1)// 左边至少有两个点的时候
            return isBST(Arrays.copyOfRange(sequence, 0, i));

        if (i <= sequence.length - 3)// 右子树至少有两个点的时候
            return isBST(Arrays.copyOfRange(sequence, i, sequence.length - 1));// i是左子树的数目，1是根节点的数目

        return true;
    }

    /**
     * 将二叉搜索树转换成一个排序的双向链表。要求 不能创建任何新的结点，只能调整树中结点指针的指向。
     * 
     * @param root
     * @return
     */
    public static BinaryTreeNode asDoublyLinkedList(BinaryTreeNode root)
    {
        BinaryTreeNode lastNodeList = null;
        convertNode(root, lastNodeList);
        while (lastNodeList != null && lastNodeList.left != null)
        {
            lastNodeList = lastNodeList.left;
        }
        return lastNodeList;
    }

    private static void convertNode(BinaryTreeNode root, BinaryTreeNode lastNodeList)
    {
        if (root == null)
            return;
        BinaryTreeNode cuurent = root;
        if (cuurent.left != null)
        {
            convertNode(cuurent.left, lastNodeList);
        }
        cuurent.left = lastNodeList;
        if (lastNodeList != null)
            lastNodeList.right = cuurent;
        lastNodeList = cuurent;
        if (cuurent.right != null)
        {
            convertNode(cuurent.right, lastNodeList);
        }
    }
}
