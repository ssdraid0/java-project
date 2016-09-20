package algorithm;

import algorithm.BinaryTreeQuestion.TreeNode;

/**
 * 1.什么是二叉搜索树/二叉查找树/二叉排序树？查找，插入，删除操作的时间复杂度是多少？ <br>
 * 二叉搜索树：左子树上的结点都小于根结点，右子树上的结点都大于根结点。<br>
 * 平均：O(logn)，最坏：O(n)。<br>
 * https://en.wikipedia.org/wiki/Binary_search_tree<br>
 * <br>
 * 2.实现二叉搜索树下面算法。<br>
 * 输入一颗二叉搜索树的头结点和一个int类型value，把value插入这颗二叉搜索树中，。<br>
 * 返回根结点。<br>
 * {@link #insert(TreeNode, int)}。<br>
 * 输入一颗二叉搜索树的头结点和一个int类型value，把二叉搜索树中值为value的结点删除，<br>
 * 返回根结点。<br>
 * {@link #remove(TreeNode, int)}。<br>
 * 输入一颗二叉搜索树的头结点和一个int类型value，如果二叉搜索树存在值为value的结点，返回true。<br>
 * {@link #contains(TreeNode, int)}。<br>
 * <br>
 * 3.输入一个二叉树的根结点，转换成一个排序的双向链表，返回头结点。<br>
 * {@link #asDoublyLinkedList(TreeNode)}。<br>
 * 4.输入一个int数组，如果是某颗二叉搜索树的后序遍历，返回true。<br>
 * {@link #isPostTraverse(int[], int, int)}。<br>
 */
public class BinarySearchTreeQuestion
{
    public static void main(String[] args)
    {

    }

    /**
     * 输入一个int数组，构造一颗二叉搜索树，返回根结点。<br>
     */
    public static TreeNode create(int[] a)
    {
        if (a == null || a.length == 0)
            return null;
        TreeNode root = new TreeNode();
        root.value = a[0];
        for (int i = 1; i < a.length; i++)
            insert(root, a[i]);
        return root;
    }

    /**
     * 输入一颗二叉搜索树的头结点和一个int类型value，把value插入这颗二叉搜索树中，<br>
     * 返回根结点。<br>
     * http://blog.sina.com.cn/s/blog_937cbcc10101dmqm.html<br>
     */
    public static TreeNode insert(TreeNode root, int value)
    {
        if (root == null)
        {
            TreeNode node = new TreeNode();
            node.value = value;
            return node;
        }
        if (root.value > value)
        {
            root.left = insert(root.left, value);
        } else if (root.value < value)
        {
            root.right = insert(root.right, value);
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
            root.value = findMin(root.right).value;
            root.right = remove(root.right, value);
        } else
        {
            root = (root.left != null) ? root.left : root.right;
        }
        return root;
    }

    /**
     * 输入一颗二叉搜索树的头结点，找出值最小的结点，返回这个结点。<br>
     * http://blog.sina.com.cn/s/blog_937cbcc10101dmqm.html<br>
     */
    private static TreeNode findMin(TreeNode root)
    {
        if (root == null)
            return null;
        else if (root.left == null)
            return root;
        return findMin(root.left);
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
        else if (root.value < value)
            return contains(root.right, value);
        else
            return true;
    }

    // /**
    // * 判断数组是不是某二叉搜索树的后序遍历。<br>
    // * http://zhedahht.blog.163.com/blog/static/25411174200725319627/<br>
    // */
    // public static boolean isPostTraverse(int[] post)
    // {
    // if (post == null || post.length <= 0)
    // return false;
    // // 2.先要找到序列的分界点,此时因为对左子树进行了遍历所以也相当于对左子树进行了判断
    // int i; // 分界点
    // for (i = 0; i < post.length - 1; i++)
    // {
    // if (post[i] > post[post.length - 1])
    // break;
    // }
    // // 3.对序列的右子树进行判断
    // for (int j = i; j < post.length - 1; j++)
    // {
    // if (post[j] < post[post.length - 1])
    // return false;
    // }
    // // 4.当左右子树都满足的时候就要进行递归
    // if (i >= 1)// 左边至少有两个点的时候
    // return isPostTraverse(Arrays.copyOfRange(post, 0, i));
    //
    // if (i <= post.length - 3)// 右子树至少有两个点的时候
    // return isPostTraverse(Arrays.copyOfRange(post, i, post.length - 1));// i是左子树的数目，1是根节点的数目
    //
    // return true;
    // }

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
