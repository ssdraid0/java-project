package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 1.输入一个二叉树的根结点，前序遍历输出，中序遍历输出，后序遍历输出。<br>
 * {@link #preTraverse(TreeNode)}，{@link #inTraverse(TreeNode)}，{@link #postTraverse(TreeNode)}<br>
 * 2.输入一个二叉树的根结点，翻转二叉树；把二叉树镜像。 <br>
 * {@link #mirror(TreeNode)}<br>
 * 3.输入一个二叉树的根结点，返回二叉树的最大深度，最小深度。<br>
 * {@link #maxDepth(TreeNode)}，{@link #minDepth(TreeNode)}<br>
 * 4.输入一个二叉树的根结点，按照从上往下，同一层从左到右的顺序打印结点。<br>
 * {@link #printFromTopToBottom(TreeNode)}<br>
 * 5.输入一个二叉树的根结点，如果这个二叉树对称，返回true。<br>
 * {@link #isSymmetric(TreeNode)}<br>
 * 6.输入一个二叉树的根结点，输出和为某值的所有路径。<br>
 * {@link #findPath(TreeNode, int)}<br>
 * 7.输入一个二叉树的前序遍历和中序遍历的结果，重建二叉树，返回根结点。<br>
 * {@link #construct(int[], int[])}<br>
 * 8.输入两个二叉树的根结点root1，root2，<br>
 * 如果第2个二叉树是第1个二叉树的子树，返回true。 <br>
 * {@link #hasSubTree(TreeNode, TreeNode)}<br>
 */
public class BinaryTree
{
    public static void main(String[] args)
    {
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        TreeNode node5 = new TreeNode();
        node1.value = 1;
        node2.value = 2;
        node3.value = 3;
        node4.value = 4;
        node5.value = 5;
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = node5;
        System.out.println("maxDepth：" + maxDepth(node1));
        System.out.println("minDepth：" + minDepth(node1));
        constructTest();
    }

    public static class TreeNode
    {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode()
        {
        }

        public TreeNode(int value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return Integer.toString(value);
        }
    }

    public static void preTraverse(TreeNode root)
    {
        if (root != null)
        {
            System.out.print(root.value);
            preTraverse(root.left);
            preTraverse(root.right);
        }
    }

    /**
     * https://leetcode.com/problems/binary-tree-inorder-traversal/<br>
     */
    public static void inTraverse(TreeNode root)
    {
        if (root != null)
        {
            inTraverse(root.left);
            System.out.print(root.value);
            inTraverse(root.right);
        }
    }

    public static void postTraverse(TreeNode root)
    {
        if (root != null)
        {
            postTraverse(root.left);
            postTraverse(root.right);
            System.out.print(root.value);
        }
    }

    /**
     * 输入一个二叉树的根结点，翻转二叉树；把二叉树镜像。
     */
    public static void mirror(TreeNode root)
    {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }

    /**
     * 输入一个二叉树的根结点，返回二叉树的最大深度。<br>
     * {@link https://leetcode.com/problems/maximum-depth-of-binary-tree/}<br>
     */
    public static int maxDepth(TreeNode root)
    {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 输入一个二叉树的根结点，返回二叉树的最小深度。<br>
     * https://leetcode.com/problems/minimum-depth-of-binary-tree/<br>
     */
    public static int minDepth(TreeNode root)
    {
        if (root == null)
            return 0;
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /**
     * 输入一个二叉树的根结点，如果这个二叉树对称，返回true。<br>
     * https://leetcode.com/problems/symmetric-tree/<br>
     */
    public static boolean isSymmetric(TreeNode root)
    {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private static boolean isSymmetricHelp(TreeNode left, TreeNode right)
    {
        if (left == null || right == null)
            return left == right;
        if (left.value != right.value)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    /**
     * 输入一个二叉树的根结点，按照从上往下，同一层从左到右的顺序打印结点。
     */
    public static void printFromTopToBottom(TreeNode root)
    {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
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

    /**
     * 输入一个二叉树的根结点，返回任意两个结点间的最大值。<br>
     * https://leetcode.com/problems/binary-tree-maximum-path-sum/<br>
     */
    public static int maxPathSum(TreeNode root)
    {
        int maxValue = Integer.MIN_VALUE;
        maxPathSum(root, maxValue);
        return maxValue;
    }

    private static int maxPathSum(TreeNode root, int maxValue)
    {
        if (root == null)
            return 0;
        int left = Math.max(0, maxPathSum(root.left, maxValue)); // 考虑负数
        int right = Math.max(0, maxPathSum(root.right, maxValue)); // 考虑负数
        maxValue = Math.max(maxValue, left + right + root.value); // 考虑左结点->父结点->右结点这种路径
        return Math.max(left, right) + root.value; // 返回在一定包含node结点情况下的最大值
    }

    /**
     * 输入一个二叉树的根结点，输出和为某值的所有路径。<br>
     * https://leetcode.com/problems/path-sum/<br>
     */
    public static void findPath(TreeNode root, int sum)
    {
        if (root == null)
            return;
        Stack<Integer> stack = new Stack<Integer>();
        int currentSum = 0;
        findPath(root, sum, stack, currentSum);
    }

    private static void findPath(TreeNode root, int sum, Stack<Integer> stack, int currentSum)
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
     * 输入一个二叉树的前序遍历和中序遍历的结果，重建二叉树，返回根结点。
     * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
     */
    public static TreeNode construct(int[] pre, int[] in)
    {
        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd)
    {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode();
        root.value = pre[preStart];
        for (int i = inStart; i <= inEnd; i++)
        {
            if (in[i] == pre[preStart])
            {
                root.left = construct(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                root.right = construct(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
            }
        }
        return root;
    }

    // public static TreeNode construct(int[] pre, int[] in)
    // {
    // if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length)
    // return null;
    // TreeNode root = new TreeNode();
    // for (int i = 0; i < in.length; i++)
    // {
    // if (in[i] == pre[0])
    // {
    // root.value = in[i];
    // root.left = construct(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
    // root.right = construct(Arrays.copyOfRange(pre, i + 1, pre.length),
    // Arrays.copyOfRange(in, i + 1, in.length));
    // }
    // }
    // return root;
    // }

    /**
     * 输入两个二叉树的根结点root1，root2，<br>
     * 如果第2个二叉树是第1个二叉树的子树，返回true。 <br>
     * http://zhedahht.blog.163.com/blog/static/25411174201011445550396/<br>
     */
    public static boolean hasSubTree(TreeNode root1, TreeNode root2)
    {
        if (root1 == null || root2 == null)
        {
            return false;
        }
        boolean result = false;
        if (root1.value == root2.value)
        {
            result = isTree1HasTree2(root1, root2);
        }
        if (!result)
        {
            result = hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
        }
        return result;
    }

    private static boolean isTree1HasTree2(TreeNode root1, TreeNode root2)
    {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.value != root2.value)
        {
            return false;
        }
        return isTree1HasTree2(root1.left, root2.left) && isTree1HasTree2(root1.right, root2.right);
    }

    /**
     * 输入一个二叉树的根结点root和它的两个结点node1和node2，找出node1和node2的最低共同父结点。<br>
     * http://zhedahht.blog.163.com/blog/static/25411174201081263815813/<br>
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/<br>
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2)
    {
        if (root == null || root == node1 || root == node2)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }

    // public static TreeNode construct(int[] pre, int[] in)
    // {
    // if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length)
    // return null;
    // TreeNode root = new TreeNode();
    // for (int i = 0; i < in.length; i++)
    // {
    // if (in[i] == pre[0])
    // {
    // root.value = in[i];
    // root.left = construct(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
    // root.right = construct(Arrays.copyOfRange(pre, i + 1, pre.length),
    // Arrays.copyOfRange(in, i + 1, in.length));
    // }
    // }
    // return root;
    // }

    private static void constructTest()
    {
        int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
        TreeNode root2 = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        preTraverse(root2);
        System.out.println();
        inTraverse(root2);
        // System.out.println(hasSubTree(root1, root2));
    }

    @SuppressWarnings("unused")
    private static void printFromTopToBottomTest()
    {
        TreeNode root1 = new TreeNode();
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        TreeNode node5 = new TreeNode();
        TreeNode node6 = new TreeNode();
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
}
