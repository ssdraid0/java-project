package algorithm;

import java.util.Stack;

/**
 * 已有二叉树类{@link BinaryTreeNode}，实现下面算法。<br>
 * 1.翻转二叉树；二叉树镜像。 <br>
 * {@link BinaryTreeQuestion#mirror(BinaryTreeNode)}。<br>
 * 2.计算二叉树深度。<br>
 * {@link BinaryTreeQuestion#depth(BinaryTreeNode)}。<br>
 * 3.判断是否是平衡二叉树。<br>
 * {@link BinaryTreeQuestion#isBanlanced(BinaryTreeNode)}。<br>
 * 4.找出和为某值的所有路径。<br>
 *{@link BinaryTreeQuestion#findPath(BinaryTreeNode, int)}。<br>
 *
 */
public class BinaryTreeQuestion
{
    public static void main(String[] args)
    {
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        BinaryTreeNode node5 = new BinaryTreeNode();
        node1.value = 1;
        node2.value = 2;
        node3.value = 3;
        node4.value = 4;
        node5.value = 5;
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = node5;
        System.out.println(depth(node1));
        System.out.println(isBanlanced(node1));

    }

    public static class BinaryTreeNode
    {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 翻转二叉树；二叉树镜像。
     */
    public static void mirror(BinaryTreeNode root)
    {
        if (root == null)
            return;
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }

    /**
     * 计算二叉树深度。
     */
    public static int depth(BinaryTreeNode root)
    {
        if (root == null)
            return 0;
        int left = 1;
        int right = 1;
        left += depth(root.left);
        right += depth(root.right);
        return left >= right ? left : right;
    }

    /**
     * 判断是否是平衡二叉树。
     */
    public static boolean isBanlanced(BinaryTreeNode root)
    {
        return isBanlanced(root, 0);
    }

    private static boolean isBanlanced(BinaryTreeNode root, int depth)
    {
        if (root == null)
        {
            depth = 0;
            return true;
        }
        int left = 1, right = 1;
        if (isBanlanced(root.left, left) && isBanlanced(root.right, right))
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

    /**
     * 找出和为某值的所有路径。
     */
    public static void findPath(BinaryTreeNode root, int sum)
    {
        if (root == null)
            return;
        Stack<Integer> stack = new Stack<Integer>();
        int currentSum = 0;
        findPath(root, sum, stack, currentSum);
    }

    private static void findPath(BinaryTreeNode root, int sum, Stack<Integer> stack, int currentSum)
    {
        currentSum += root.value;
        stack.push(root.value);
        if (root.left == null && root.right == null)
        {
            if (currentSum == sum)
            {
                System.out.println("找到一个路径");
                for (int path : stack)
                {
                    System.out.print(path + " ");
                }
                System.out.println();
            }
        }
        if (root.left != null)
        {
            findPath(root.left, sum, stack, currentSum);
        }
        if (root.right != null)
        {
            findPath(root.right, sum, stack, currentSum);
        }
        stack.pop();
    }
}
