package data_structure.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree
{
    /**
     * 判断 以root2 为根结点的二叉树是不是以root1为根结点的二叉树的子树。
     * 
     * @param root1
     *            一个二叉树根结点
     * @param root2
     *            另一个二叉树根结点
     * @return
     */
    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2)
    {
        boolean result = false;
        if (root1 != null && root2 != null)
        {
            if (root1.value == root2.value)
            {
                result = doesTree1HavaTree2(root1, root2);
                if (!result)
                    result = hasSubTree(root1.left, root2);
                if (!result)
                    result = hasSubTree(root1.right, root2);
            }
        }
        return result;
    }

    private static boolean doesTree1HavaTree2(BinaryTreeNode root1, BinaryTreeNode root2)
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
        return doesTree1HavaTree2(root1.left, root2.left) && doesTree1HavaTree2(root1.right, root2.right);
    }

    /**
     * 输出一个二叉树的镜像
     * 
     * @param root
     * @return
     */
    public static BinaryTreeNode mirror(BinaryTreeNode root)
    {
        if (root == null)
        {
            return null;
        }
        if (root.left == null && root.right == null)
            return null;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        while (root != null || !stack.isEmpty())
        {
            while (root != null)
            {
                BinaryTreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return root;
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

}
