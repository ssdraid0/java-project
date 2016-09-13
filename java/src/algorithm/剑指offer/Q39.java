package algorithm.剑指offer;

/**
 * 面试题 39：二叉树的深度
 * <P>
 * 题目一：输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过 的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 题目二：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树 中任意结点的左右子树的深度相差不超过1，那么他就是一棵平衡二叉树。
 */
public class Q39
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = new BinaryTreeNode();
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        BinaryTreeNode node5 = new BinaryTreeNode();
        BinaryTreeNode node6 = new BinaryTreeNode();
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node4.left = node6;
        root.data = 1;
        node1.data = 2;
        node2.data = 3;
        node3.data = 4;
        node4.data = 5;
        node5.data = 6;
        node6.data = 7;
        System.out.println(treeDepth(root));
        System.out.println(isBalanced(root));

    }

    public static int treeDepth(BinaryTreeNode root)
    {
        if (root == null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return (left > right) ? left + 1 : right + 1;
    }

    public static boolean isBalanced(BinaryTreeNode root)
    {
        int depth = 0;
        return isBalanced(root, depth);
    }

    private static boolean isBalanced(BinaryTreeNode root, int depth)
    {
        if (root == null)
        {
            depth = 0;
            return true;
        }
        int left = 0, right = 0;
        if (isBalanced(root.left, left) && isBalanced(root.right, right))
        {
            int diff = left - right;
            if (diff <= 1 && diff >= -1)
            {
                depth = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }

    private static class BinaryTreeNode
    {
        BinaryTreeNode left;
        BinaryTreeNode right;
        int data;
    }
}
