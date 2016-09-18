package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 已有二叉树类{@link BinaryTreeNode}，实现下面算法。<br>
 * 1.翻转二叉树；二叉树镜像。 <br>
 * {@link BinaryTreeQuestion#mirror(BinaryTreeNode)}。<br>
 * 2.计算二叉树深度。<br>
 * {@link BinaryTreeQuestion#depth(BinaryTreeNode)}。<br>
 * 3.从上往下打印二叉树的每个结点，同一层的结点按照从左到右的顺序打印。<br>
 * {@link BinaryTreeQuestion#printFromTopToBottom(BinaryTreeNode)}。<br>
 * 4.判断是否是平衡二叉树。<br>
 * {@link BinaryTreeQuestion#isBanlanced(BinaryTreeNode)}。<br>
 * 5.找出二叉树中和为某值的所有路径。<br>
 * {@link BinaryTreeQuestion#findPath(BinaryTreeNode, int)}。<br>
 * 6.根据前序遍历和中序遍历的结果重建二叉树。<br>
 * {@link BinaryTreeQuestion#construct(int[], int[])}。<br>
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
        int left = depth(root.left) + 1;
        int right = depth(root.right) + 1;
        return left >= right ? left : right;
    }

    /**
     * 从上往下打印二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
     */
    public static void printFromTopToBottom(BinaryTreeNode root)
    {
        if (root == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.value);
            if (node.left != null)
            {
                queue.add(node.left);
            }
            if (node.right != null)
            {
                queue.add(node.right);
            }
        }
    }

    public static void printFromTopToBottomTest()
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
        printFromTopToBottom(root1);
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
                for (Integer path : stack)
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

    /**
     * 根据前序遍历和中序遍历的结果重建二叉树。
     */
    public static BinaryTreeNode construct(int[] preOrder, int[] inOrder)
    {
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length)
            return null;
        BinaryTreeNode root = new BinaryTreeNode();
        for (int i = 0; i < inOrder.length; i++)
        {
            if (inOrder[i] == preOrder[0])
            {
                root.value = inOrder[i];
                root.left = construct(Arrays.copyOfRange(preOrder, 1, i + 1), Arrays.copyOfRange(inOrder, 0, i));
                root.right = construct(Arrays.copyOfRange(preOrder, i + 1, preOrder.length),
                        Arrays.copyOfRange(inOrder, i + 1, inOrder.length));
            }
        }
        return root;
    }

    public static void constructTest()
    {
        int[] preSort = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] inSort = { 4, 7, 2, 1, 5, 3, 8, 6 };
        construct(preSort, inSort);
    }

    /**
     * 判断 以root2 为根结点的二叉树是不是以root1为根结点的二叉树的子树。
     */
    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2)
    {
        boolean result = false;
        if (root1 != null && root2 != null)
        {
            if (root1.value == root2.value)
            {
                result = isTree1HavaTree2(root1, root2);
            }
            if (!result)
            {
                result = hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
            }
        }
        return result;
    }

    private static boolean isTree1HavaTree2(BinaryTreeNode root1, BinaryTreeNode root2)
    {
        if (root2 == null)
        {
            return true;
        } else if (root1 == null)
            return false;
        if (root1.value != root2.value)
        {
            return false;
        }
        return isTree1HavaTree2(root1.left, root2.left) && isTree1HavaTree2(root1.right, root2.right);
    }
}
