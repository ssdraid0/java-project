package algorithm;

import algorithm.BinaryTreeQuestion.TreeNode;

/**
 * 1.输入一个二叉树的根结点，如果是平衡二叉树，返回true。<br>
 * {@link #isBanlanced(TreeNode)}<br>
 */
public class BinaryBalancedTreeQuestion
{
    public static void main(String[] args)
    {
        int[] a = { 1, 2, 3, 4, 5 };
        AVLTreeNode root = new AVLTreeNode();
        root.value = 0;
        for (int i : a)
        {
            root = insert(root, i);
        }
        remove(root, 3);
    }

    public static class AVLTreeNode
    {
        int height;
        int value;
        AVLTreeNode left;
        AVLTreeNode right;

        @Override
        public String toString()
        {
            return Integer.toString(value);
        }
    }

    /**
     * 输入一颗AVL树的头结点和一个int类型value，把value插入这颗AVL树中，<br>
     * 返回根结点。<br>
     * http://blog.csdn.net/liyong199012/article/details/29219261<br>
     */
    public static AVLTreeNode insert(AVLTreeNode root, int value)
    {
        if (root == null)
        {
            AVLTreeNode node = new AVLTreeNode();
            node.value = value;
            return node;
        }
        if (root.value > value)
        {
            root.left = insert(root.left, value);
            root = fixAfterInsertLeft(root, value);
        } else if (root.value < value)
        {
            root.right = insert(root.right, value);
            root = fixAfterInsertRight(root, value);
        }
        root.height = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return root;
    }

    /**
     * 输入一颗AVL树的头结点和一个int类型value，把AVL树中值为value的结点删除，<br>
     * 返回根结点。<br>
     * http://blog.csdn.net/liyong199012/article/details/29219261<br>
     */
    public static AVLTreeNode remove(AVLTreeNode root, int value)
    {
        if (root == null)
            return null;
        if (root.value > value)
        {
            root.left = remove(root.left, value);
            root = fixAfterRemoveLeft(root);
            root.height = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        } else if (root.value < value)
        {
            root.right = remove(root.right, value);
            root = fixAfterRemoveRight(root);
            root.height = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        } else if (root.left != null && root.right != null)
        {
            // 默认用其右子树的最小数据代替该节点的数据
            root.value = findMin(root.right).value;
            root.right = remove(root.right, root.value);
            root = fixAfterRemoveRoot(root);
            root.height = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        } else
        {
            root = (root.left != null) ? root.left : root.right;
        }
        return root;
    }

    /**
     * 输入一颗AVL树的头结点和一个int类型value，如果AVL树存在值为value的结点，返回true。<br>
     * http://blog.sina.com.cn/s/blog_937cbcc10101dmqm.html<br>
     */
    public static boolean contains(AVLTreeNode root, int value)
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

    private static AVLTreeNode fixAfterInsertLeft(AVLTreeNode root, int value)
    {
        if (maxDepth(root.left) - maxDepth(root.right) == 2)
        {
            if (root.left.value > value)
                root = rotateLL(root);
            else
                root = rotateLR(root);
        }
        return root;
    }

    private static AVLTreeNode fixAfterInsertRight(AVLTreeNode root, int value)
    {
        if (maxDepth(root.right) - maxDepth(root.left) == 2)
        {
            if (root.right.value > value)
                root = rotateRL(root);
            else
                root = rotateRR(root);
        }
        return root;
    }

    private static AVLTreeNode fixAfterRemoveRoot(AVLTreeNode root)
    {
        if (root.right == null)
        {        // 若右子树删除后为空，则只需判断左子树与根的高度差
            if (maxDepth(root.left) - root.height == 2)
            {
                AVLTreeNode k = root.left;
                if (k.left != null)
                {
                    System.out.println("ffff");
                    root = rotateLL(root);
                } else
                {
                    System.out.println("gggg");
                    root = rotateLR(root);
                }
            }
        } else
        {   // 若右子树删除后非空，则判断左右子树的高度差
            // 右子树自身也可能不平衡，故先平衡右子树，再考虑整体
            AVLTreeNode k = root.right;
            // 删除操作默认用右子树上最小节点（靠左）补删除的节点
            if (k.left != null)
            {
                if (maxDepth(k.right) - maxDepth(k.left) == 2)
                {
                    AVLTreeNode m = k.right;
                    if (m.right != null)
                    {        // 右子树存在，按正常情况单旋转
                        System.out.println("hhhh");
                        k = rotateRR(k);
                    } else
                    {                      // 否则是右左情况，双旋转
                        System.out.println("iiii");
                        k = rotateRL(k);
                    }
                }
            } else
            {
                if (maxDepth(k.right) - k.height == 2)
                {
                    AVLTreeNode m = k.right;
                    if (m.right != null)
                    {        // 右子树存在，按正常情况单旋转
                        System.out.println("jjjj");
                        k = rotateRR(k);
                    } else
                    {                      // 否则是右左情况，双旋转
                        System.out.println("kkkk");
                        k = rotateRL(k);
                    }
                }
            }
            // 左子树自身一定是平衡的，左右失衡的话单旋转可以解决问题
            if (maxDepth(root.left) - maxDepth(root.right) == 2)
            {
                System.out.println("llll");
                root = rotateLL(root);
            }
        }
        return root;
    }

    private static AVLTreeNode fixAfterRemoveLeft(AVLTreeNode root)
    {
        if (root.right != null)
        {        // 若右子树为空，则一定是平衡的，此时左子树相当对父节点深度最多为1, 所以只考虑右子树非空情况
            if (root.left == null && maxDepth(root.right) - root.height == 2)
            {     // 若左子树删除后为空，则需要判断右子树
                AVLTreeNode right = root.right;
                if (right.right != null)
                {        // 右子树存在，按正常情况单旋转
                    System.out.println("1111");
                    root = rotateRR(root);
                } else
                {        // 否则是右左情况，双旋转
                    System.out.println("2222");
                    root = rotateRL(root);
                }
            } else
            {   // 否则判断左右子树的高度差
                // 左子树自身也可能不平衡，故先平衡左子树，再考虑整体
                AVLTreeNode left = root.left;
                // 删除操作默认用右子树上最小节点补删除的节点
                // k的左子树高度不低于k的右子树
                if (left.right != null && maxDepth(left.left) - maxDepth(left.right) == 2)
                {
                    AVLTreeNode m = left.left;
                    if (m.left != null)
                    {   // 左子树存在，按正常情况单旋转
                        System.out.println("3333");
                        left = rotateLL(left);
                    } else
                    {   // 否则是左右情况，双旋转
                        System.out.println("4444");
                        left = rotateLR(left);
                    }
                } else
                {
                    if (maxDepth(left.left) - left.height == 2)
                    {
                        AVLTreeNode m = left.left;
                        if (m.left != null)
                        {     // 左子树存在，按正常情况单旋转
                            System.out.println("5555");
                            left = rotateLL(left);
                        } else
                        {                      // 否则是左右情况，双旋转
                            System.out.println("6666");
                            left = rotateLR(left);
                        }
                    }
                }
                if (maxDepth(root.right) - maxDepth(root.left) == 2)
                {
                    // 右子树自身一定是平衡的，左右失衡的话单旋转可以解决问题
                    System.out.println("7777");
                    root = rotateRR(root);
                }
            }
        }
        return root;
    }

    private static AVLTreeNode fixAfterRemoveRight(AVLTreeNode root)
    {
        // 下面验证子树是否平衡
        if (root.left != null)
        {         // 若左子树为空，则一定是平衡的，此时右子树相当对父节点深度最多为1
            if (root.right == null)
            {        // 若右子树删除后为空，则只需判断左子树
                if (maxDepth(root.left) - root.height == 2)
                {
                    AVLTreeNode k = root.left;
                    if (k.left != null)
                    {
                        System.out.println("8888");
                        root = rotateLL(root);
                    } else
                    {
                        System.out.println("9999");
                        root = rotateLR(root);
                    }
                }
            } else
            {              // 若右子树删除后非空，则判断左右子树的高度差
                // 右子树自身也可能不平衡，故先平衡右子树，再考虑整体
                AVLTreeNode k = root.right;
                // 删除操作默认用右子树上最小节点（靠左）补删除的节点
                // k的右子树高度不低于k的左子树
                if (k.left != null)
                {
                    if (maxDepth(k.right) - maxDepth(k.left) == 2)
                    {
                        AVLTreeNode m = k.right;
                        if (m.right != null)
                        {        // 右子树存在，按正常情况单旋转
                            System.out.println("aaaa");
                            k = rotateRR(k);
                        } else
                        {                      // 否则是右左情况，双旋转
                            System.out.println("bbbb");
                            k = rotateRL(k);
                        }
                    }
                } else
                {
                    if (maxDepth(k.right) - k.height == 2)
                    {
                        AVLTreeNode m = k.right;
                        if (m.right != null)
                        {        // 右子树存在，按正常情况单旋转
                            System.out.println("cccc");
                            k = rotateRR(k);
                        } else
                        {                      // 否则是右左情况，双旋转
                            System.out.println("dddd");
                            k = rotateRL(k);
                        }
                    }
                }
                if (maxDepth(root.left) - maxDepth(root.right) == 2)
                {
                    // 左子树自身一定是平衡的，左右失衡的话单旋转可以解决问题
                    System.out.println("eeee");
                    root = rotateLL(root);
                }
            }
        }
        return root;
    }

    private static AVLTreeNode rotateLL(AVLTreeNode root)
    {
        AVLTreeNode left = root.left;
        root.left = left.right;
        left.right = root;
        return left;
    }

    private static AVLTreeNode rotateRR(AVLTreeNode root)
    {
        AVLTreeNode right = root.right;
        root.right = right.left;
        right.left = root;
        return right;
    }

    private static AVLTreeNode rotateLR(AVLTreeNode root)
    {
        root.left = rotateRR(root.left);
        return rotateLR(root);
    }

    private static AVLTreeNode rotateRL(AVLTreeNode root)
    {
        root.right = rotateLR(root.right);
        return rotateRR(root);
    }

    private static int maxDepth(AVLTreeNode root)
    {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    private static AVLTreeNode findMin(AVLTreeNode root)
    {
        if (root == null)
            return null;
        else if (root.left == null)
            return root;
        return findMin(root.left);
    }

    /**
     * 输入一个二叉树的根结点，如果是平衡二叉树，返回true。<br>
     * http://zhedahht.blog.163.com/blog/static/25411174201142733927831/<br>
     */
    public static boolean isBanlanced(TreeNode root)
    {
        return isBanlanced(root, 0);
    }

    private static boolean isBanlanced(TreeNode root, int depth)
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
}
