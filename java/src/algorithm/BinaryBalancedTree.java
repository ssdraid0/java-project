package algorithm;

import algorithm.BinaryTree.TreeNode;

/**
 * 1.输入一个二叉树的根结点，如果是平衡二叉树，返回true。<br>
 * {@link #isBanlanced(TreeNode, int)}<br>
 * <br>
 * 2.什么是AVL树/自平衡二叉搜索树？查找，插入，删除操作的时间复杂度是多少？ <br>
 * AVL树：既是二叉搜索树又是平衡二叉树。<br>
 * 平均：都是O(logn)，最坏：都是O(logn)。<br>
 * <br>
 * 3.AVL树的旋转分为几种情形？<br>
 * {@link #rotateLL(AVLTreeNode)}，{@link #rotateRR(AVLTreeNode)}。<br>
 * {@link #rotateLR(AVLTreeNode)}，{@link #rotateRL(AVLTreeNode)}。<br>
 * <br>
 * 4.输入一颗AVL树的头结点和一个int类型value，把value插入这颗二叉搜索树中。<br>
 * 返回根结点。<br>
 * {@link #add(AVLTreeNode, int)}。<br>
 * <br>
 * [ToDo]5.输入一颗AVL树的头结点和一个int类型value，把值为value的结点删除，<br>
 * 返回根结点。<br>
 * {@link #remove(AVLTreeNode, int)}。<br>
 * <br>
 * [ToDo]6.输入一颗AVL树的头结点和一个int类型value，如果存在值为value的结点，返回true。<br>
 * {@link #contains(AVLTreeNode, int)}。<br>
 * <br>
 */
public class BinaryBalancedTree
{
    public static void main(String[] args)
    {
        int[] a = { 1, 2, 3, 4, 5 };
        AVLTreeNode root = null;
        for (int i : a)
        {
            root = add(root, i);
        }
        remove(root, 3);
    }

    /**
     * 输入一个二叉树的根结点，如果是平衡二叉树，返回true。<br>
     * http://zhedahht.blog.163.com/blog/static/25411174201142733927831/<br>
     * 使用示例：调用isBanlanced(root, 0);<br>
     */
    public static boolean isBanlanced(TreeNode root, int depth)
    {
        if (root == null)
        {
            depth = 0;
            return true;
        }
        int left = 1, right = 1;
        if (isBanlanced(root.left, left) && isBanlanced(root.right, right))
        {
            if (Math.abs(left - right) <= 1)
            {
                depth = 1 + Math.max(left, right);
                return true;
            }
        }
        return false;
    }

    /**
     * LL型：左子树的某个叶子结点添加了左结点，导致根结点不平衡。<br>
     * 例如：①是新插入的结点，结点⑤不平衡。<br>
     * 把⑤作为③的右子树，③的右子树变为⑤的左子数。<br>
     * <br>
     * -------⑤----->>--------③-------<br>
     * ----③--⑥-->>-----②--⑤----<br>
     * --②④------>>--①---④⑥--<br>
     * ①------------>>-------------------<br>
     * <br>
     */
    public static AVLTreeNode rotateLL(AVLTreeNode root)
    {
        AVLTreeNode left = root.left;
        root.left = left.right;
        left.right = root;
        return left;
    }

    /**
     * RR型：右子树的某个叶子结点添加了右结点，导致根结点不平衡。<br>
     * 例如：⑥是新插入的结点，结点②不平衡。<br>
     * 把②作为④的左子树，④的左子树变为②的右子数。<br>
     * <br>
     * ---②--------->>-------④-------<br>
     * ①--④------>>----②--⑤----<br>
     * ----③⑤---->>--①③--⑥--<br>
     * ----------⑥-->>------------------<br>
     * <br>
     */
    public static AVLTreeNode rotateRR(AVLTreeNode root)
    {
        AVLTreeNode right = root.right;
        root.right = right.left;
        right.left = root;
        return right;
    }

    /**
     * LR型：左子树的某个叶子结点添加了右结点，导致根结点不平衡。<br>
     * 例如：⑦是新插入的结点，结点⑧不平衡。<br>
     * 先对③结点RR型操作，在对⑧结点LL型操作。<br>
     * <br>
     * ---------⑧---------->>------------⑧-------->>----------⑤-----------<br>
     * -----③----⑨------>>--------⑤----⑨---->>-----③------⑧------<br>
     * --②--⑤-----⑩-->>-----③--⑥----⑩->>---②④--⑥⑨----<br>
     * ①--④⑥--------->>---②④--⑦------->>--①------⑦---⑩--<br>
     * ------------⑦------->>-①------------------->>-------------------------<br>
     * <br>
     */
    public static AVLTreeNode rotateLR(AVLTreeNode root)
    {
        root.left = rotateRR(root.left);
        return rotateLL(root);
    }

    /**
     * RL型：右子树的某个叶子结点添加了左结点，导致根结点不平衡。<br>
     * 例如：⑥是新插入的结点，结点③不平衡。<br>
     * 先对⑧结点LL型操作，在对③结点RR型操作。<br>
     * <br>
     * ---------③--------------->>---------③------------->>------------⑤------------<br>
     * ----②------⑧---------->>-----②-----⑤-------->>-----③---------⑧------<br>
     * ①------⑤----⑨------>>--①-----④--⑧----->>---②④-----⑦⑨----<br>
     * -------④--⑦-----⑩-->>---------------⑦⑨--->>--①---------⑥---⑩--<br>
     * -----------⑥------------->>------------- ⑥---⑩-->>----------------------------<br>
     * <br>
     */
    public static AVLTreeNode rotateRL(AVLTreeNode root)
    {
        root.right = rotateLL(root.right);
        return rotateRR(root);
    }

    /**
     * 输入一颗AVL树的头结点和一个int类型value，把value插入这颗AVL树中，<br>
     * 返回根结点。<br>
     * http://blog.csdn.net/liyong199012/article/details/29219261<br>
     */
    public static AVLTreeNode add(AVLTreeNode root, int value)
    {
        if (root == null)
        {
            AVLTreeNode node = new AVLTreeNode(value);
            return node;
        }
        if (root.value > value)
        {
            root.left = add(root.left, value);
            root = fixAfterInsertLeft(root, value);
        } else if (root.value < value)
        {
            root.right = add(root.right, value);
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
            root.height = maxDepth(root);
        } else if (root.value < value)
        {
            root.right = remove(root.right, value);
            root = fixAfterRemoveRight(root);
            root.height = maxDepth(root);
        } else if (root.left != null && root.right != null)
        {
            // 默认用其右子树的最小数据代替该节点的数据
            root.value = findMin(root.right).value;
            root.right = remove(root.right, root.value);
            root = fixAfterRemoveRoot(root);
            root.height = maxDepth(root);
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

    /**
     * https://en.wikipedia.org/wiki/AVL_tree<br>
     */
    public static class AVLTreeNode
    {
        int height;
        int value;
        AVLTreeNode left;
        AVLTreeNode right;

        public AVLTreeNode()
        {
        }

        public AVLTreeNode(int value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return Integer.toString(value);
        }
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
}
