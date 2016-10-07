package algorithm;

/**
 * ⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽<br/>
 * 1.红黑数的性质有哪些？<br/>
 * ⑴.每个连接都分为红色和黑色。<br/>
 * ⑵.红色的连接一定是向左的。<br/>
 * ⑶.红色节点的父、左、右节点都是黑色。<br/>
 * ⑷.在任何一棵子树中，每一条从根节点向下走到空节点的路径上包含的黑色连接数量都相同。<br/>
 * http://algs4.cs.princeton.edu/33balanced/RedBlackLiteBST.java.html<br/>
 * http://algs4.cs.princeton.edu/33balanced/RedBlackBST.java.html<br/>
 * http://blog.csdn.net/yangchuxi/article/details/6745488<br/>
 */
public class RedBlackTreeQ
{
    public static void main(String[] args)
    {

    }

    public static class Node
    {
        public int key;
        public Node left, right;
        public boolean color;     // true表示和父结点的连接是红色

        public Node(int key, boolean color)
        {
            this.key = key;
            this.color = color;
        }
    }

    /**
     * 输入一颗RedBlack树的头结点和一个int类型value，如果RedBlack树存在值为value的结点，返回true。</br>
     */
    public static boolean contains(Node root, int key)
    {
        if (root == null) return false;
        if (root.key > key) return contains(root.left, key);
        else if (root.key < key) return contains(root.right, key);
        else return true;
    }

    /**
     * 输入一颗RedBlack树的头结点和一个int类型value，把value插入这颗RedBlack树中，</br>
     * 返回根结点。</br>
     */
    public static Node put(Node root, int key)
    {
        root = putKey(root, key);
        root.color = false;
        return root;
    }

    private static Node putKey(Node root, int key)
    {
        if (root == null) return new Node(key, true);
        if (root.key > key)
        {
            root.left = put(root.left, key);
        } else if (root.key < key)
        {
            root.right = put(root.right, key);
        }
        // 下面三个操作顺序不能改变
        if (!isRed(root.left) && isRed(root.right)) root = rotateLeft(root); // 左黑右红
        if (isRed(root.left) && isRed(root.left.left)) root = rotateRight(root);// 左红左左红
        if (isRed(root.left) && isRed(root.right)) flipColors(root);// 左红右红
        return root;
    }

    public static Node remove(Node root, int key)
    {
        if (!isRed(root.left) && !isRed(root.right)) root.color = true;
        root = removeKey(root, key);
        if (root != null) root.color = false;
        return root;
    }

    private static Node removeKey(Node root, int key)
    {
        if (root == null) return null;
        if (root.key > key)
        {
            if (!isRed(root.left) && !isRed(root.left.left)) root = moveRedLeft(root);
            root.left = removeKey(root.left, key);
        } else
        {
            if (isRed(root.left)) root = rotateRight(root);
            if (key == root.key && (root.right == null)) return null;
            if (!isRed(root.right) && !isRed(root.right.left)) root = moveRedRight(root);
            if (key == root.key)
            {
                Node x = min(root.right);
                root.key = x.key;
                // h.val = get(h.right, min(h.right).key);
                // h.key = min(h.right).key;
                root.right = removeMin(root.right);
            } else root.right = removeKey(root.right, key);
            root.right = removeKey(root.right, key);
        }
        return root;
    }

    private static Node rotateLeft(Node root)
    {
        assert (root != null) && isRed(root.right);
        Node x = root.right;
        root.right = x.left;
        x.left = root;
        x.color = root.color;
        root.color = true;
        return x;
    }

    private static Node rotateRight(Node root)
    {
        assert (root != null) && isRed(root.left);
        Node x = root.left;
        root.left = x.right;
        x.right = root;
        x.color = root.color;
        root.color = true;
        return x;
    }

    private static void flipColors(Node root)
    {
        assert !isRed(root) && isRed(root.left) && isRed(root.right);
        root.color = true;
        root.left.color = false;
        root.right.color = false;
    }

    private static boolean isRed(Node h)
    {
        if (h == null) return false;
        return h.color;
    }

    private static Node moveRedLeft(Node h)
    {
        assert (h != null) && isRed(h) && !isRed(h.left) && !isRed(h.left.left);
        flipColors(h);
        if (isRed(h.right.left))
        {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    private static Node moveRedRight(Node h)
    {
        assert (h != null) && isRed(h) && !isRed(h.right) && !isRed(h.right.left);
        flipColors(h);
        if (isRed(h.left.left))
        {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    public static Node min(Node root)
    {
        if (root == null) return null;
        if (root.left == null) return root;
        return min(root.left);
    }

    private static Node removeMin(Node h)
    {
        if (h.left == null) return null;
        if (!isRed(h.left) && !isRed(h.left.left)) h = moveRedLeft(h);
        h.left = removeMin(h.left);
        return balance(h);
    }

    private static Node balance(Node h)
    {
        // assert (h != null);

        if (isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        // h.size = size(h.left) + size(h.right) + 1;
        return h;
    }
}
