package algorithm;

import algorithm.BinaryTree.TreeNode;

/**
 * 1.什么是二叉搜索树/二叉查找树/二叉排序树？查找，插入，删除操作的时间复杂度是多少？ <br>
 * 二叉搜索树：左子树上的结点都小于根结点，右子树上的结点都大于根结点。<br>
 * 平均：O(logn)，最坏：O(n)。<br>
 * https://en.wikipedia.org/wiki/Binary_search_tree<br>
 * <br>
 * 2.输入一颗二叉搜索树的头结点，找出值最小/最大的结点，返回这个结点。<br>
 * {@link #min(TreeNode)}，{@link #max(TreeNode)}。<br>
 * <br>
 * 3.输入一颗二叉搜索树的头结点和一个int类型value，如果存在值为value的结点，返回true。<br>
 * {@link #contains(TreeNode, int)}。<br>
 * <br>
 * 4.输入一颗二叉搜索树的头结点和一个int类型value，把value插入这颗二叉搜索树中。<br>
 * 返回根结点。<br>
 * {@link #add(TreeNode, int)}。<br>
 * <br>
 * 5.输入一颗二叉搜索树的头结点和一个int类型value，把值为value的结点删除，<br>
 * 返回根结点。<br>
 * {@link #remove(TreeNode, int)}。<br>
 * <br>
 * 6.输入一个二叉树的根结点，转换成一个排序的双向链表，返回头结点。<br>
 * {@link #asDoublyLinkedList(TreeNode)}。<br>
 * <br>
 * 7.输入一个int数组，如果是某颗二叉搜索树的后序遍历，返回true。<br>
 * {@link #isPostTraverse(int[], int, int)}。<br>
 */
public class BinarySearchTree
{
    public static void main(String[] args)
    {

    }

    /**
     * 输入一颗二叉搜索树的头结点，找出值最小的结点，返回这个结点。<br>
     * http://blog.sina.com.cn/s/blog_937cbcc10101dmqm.html<br>
     */
    public static TreeNode min(TreeNode root)
    {
        if (root == null)
            return null;
        if (root.left == null)
            return root;
        return min(root.left);
    }

    /**
     * 输入一颗二叉搜索树的头结点，找出值最大的结点，返回这个结点。<br>
     */
    public static TreeNode max(TreeNode root)
    {
        if (root == null)
            return null;
        if (root.right == null)
            return root;
        return max(root.right);
    }

    /**
     * 输入一颗二叉搜索树的头结点和一个int类型value，如果二叉搜索树存在值为value的结点，返回true。<br>
     * http://blog.sina.com.cn/s/blog_937cbcc10101dmqm.html<br>
     */
    public static boolean contains(TreeNode root, int value)
    {
        if (root == null)
            return false;
        if (root.value > value)
            return contains(root.left, value);
        if (root.value < value)
            return contains(root.right, value);
        return true;
    }

    /**
     * 输入一个int数组，构造一颗二叉搜索树，返回根结点。<br>
     */
    public static TreeNode create(int[] a)
    {
        if (a == null || a.length == 0)
            return null;
        TreeNode root = null;
        for (int i = 0; i < a.length; i++)
            root = add(root, a[i]);
        return root;
    }

    /**
     * 输入一颗二叉搜索树的头结点和一个int类型value，把value插入这颗二叉搜索树中，<br>
     * 返回根结点。<br>
     * http://blog.sina.com.cn/s/blog_937cbcc10101dmqm.html<br>
     */
    public static TreeNode add(TreeNode root, int value)
    {
        if (root == null)
            return new TreeNode(value);
        if (root.value > value)
        {
            root.left = add(root.left, value);
        } else if (root.value < value)
        {
            root.right = add(root.right, value);
        }
        return root;
    }

    /**
     * 输入一颗二叉搜索树的头结点和一个int类型value，把二叉搜索树中值为value的结点删除，<br>
     * 返回根结点。<br>
     * http://blog.sina.com.cn/s/blog_937cbcc10101dmqm.html<br>
     */
    public static TreeNode remove(TreeNode root, int value)
    {
        if (root == null)
            return null;
        if (root.value > value)
        {
            root.left = remove(root.left, value);
        } else if (root.value < value)
        {
            root.right = remove(root.right, value);
        } else if (root.left != null && root.right != null)
        {
            root.value = min(root.right).value;
            root.right = remove(root.right, root.value);
        } else
        {
            root = (root.left != null) ? root.left : root.right;
        }
        return root;
    }

    /**
     * 输入一个二叉树的根结点，如果是二叉搜索树，返回true。<br>
     * https://leetcode.com/problems/validate-binary-search-tree/<br>
     */
    public static boolean isBST(TreeNode root)
    {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return true;
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(TreeNode root, int min, int max)
    {
        if (root == null)
            return true;
        if (root.value <= min || root.value >= max)
            return false;
        return isBST(root.left, min, root.value) && isBST(root.right, root.value, max);
    }

    /**
     * 输入一个int数组，如果是某颗二叉搜索树的后序遍历，返回true。<br>
     * http://zhedahht.blog.163.com/blog/static/25411174200725319627/<br>
     */
    public static boolean isPostTraverse(int[] post, int start, int end)
    {
        if (post == null || post.length == 0)
            return false;
        int root = post[end];
        int i = start;
        // 找出第一个右子树的结点位置
        for (; i < end; i++)
        {
            if (post[i] > root)
                break;
        }
        // 对序列的右子树进行判断
        for (int j = i; j < end; j++)
        {
            if (post[j] < root)
                return false;
        }
        // 判断左子树是否是BST
        boolean left = true;
        if (i - 1 > start)
            left = isPostTraverse(post, start, i - 1);
        // 判断右子树是否是BST
        boolean right = true;
        if (i < end)
            right = isPostTraverse(post, i, end - 1);
        return (left && right);
    }

    /**
     * 输入一个二叉树的根结点，转换成一个排序的双向链表，返回头结点。<br>
     * http://zhedahht.blog.163.com/blog/static/254111742007127104759245/<br>
     */
    public static TreeNode asDoublyLinkedList(TreeNode root)
    {
        TreeNode lastNodeList = null;
        convertNode(root, lastNodeList);
        while (lastNodeList != null && lastNodeList.left != null)
        {
            lastNodeList = lastNodeList.left;
        }
        return lastNodeList;
    }

    private static void convertNode(TreeNode root, TreeNode lastNodeList)
    {
        if (root == null)
            return;
        TreeNode current = root;
        if (current.left != null)
        {
            convertNode(current.left, lastNodeList);
        }
        current.left = lastNodeList;
        if (lastNodeList != null)
            lastNodeList.right = current;
        lastNodeList = current;
        if (current.right != null)
        {
            convertNode(current.right, lastNodeList);
        }
    }

}
