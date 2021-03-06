package data_structure;

public class TreeQuestion
{}

/**
 * 1.什么是二叉树的深度？什么是度？什么叫叶子结点？ <br>
 * 深度：只有一个结点的二叉树的深度为0。<br>
 * 度：子结点数量。<br>
 * 叶子结点：没有子结点的结点；度为0的结点。<br>
 * <br>
 * 2.二叉树的种类有哪些？<br>
 * 完全二叉树（{@link CompleteBinaryTree}）：每层结点都填满，最后一层上如果不满，则只缺少右边的若干结点。<br>
 * 满二叉树（{@link FullBinaryTree}）：所有的结点都只有2个或0个子结点。<br>
 * 完美二叉树（{@link PerfectBinaryTree}）：所有的结点都只有2个或0个子结点，并且子结点为0个的结点都在同一层。完美二叉树是完全二叉树的一种。<br>
 * 平衡二叉树（{@link BalancedBinaryTree}）：所有的结点的左右子树的高度差不超过1。<br>
 * <br>
 * 3.二叉树有哪些性质？ <br>
 * a.度为0的节点数 = 度为2的节点数+1。<br>
 * b.。<br>
 * <br>
 * 4.一棵结点数为2016的二叉树最多有多少个叶子结点？ 最多有多少个度为2的结点？ <br>
 * 深度为9的完美二叉树有2^9-1=511个结点。 <br>
 * 深度为10的完美二叉树有2^10-1=1023个结点。 <br>
 * 深度为11的完美二叉树有2^11-1=2047个结点。 <br>
 * 这棵二叉树深度为11。<br>
 * 第11层有2016-1023=993个叶子结点。 <br>
 * 第10层有512-(993-1)/2-1=15个叶子结点。 <br>
 * 最多有993+15=1007个叶子结点。 <br>
 * 最多有1007+1=1008个度为2的结点。 <br>
 */
class BinaryTreeQuestion
{}

/**
 * 1.一个深度为10的满二叉树最少、最多有多少个结点？<br>
 * 推算：<br>
 * 深度为1的满二叉树最少1，最多1+2^1=3。<br>
 * 深度为2的满二叉树最少1+2^1=3，最多1+2^1+2^2=7。<br>
 * 深度为3的满二叉树最少1+2^1+2^2=7，最多1+2^1+2^2+2^3=15。<br>
 * 深度为n的满二叉树最少2^n-1，最多2^(n+1)-1个结点。<br>
 */
class FullBinaryTree
{}

/**
 * 1.一个深度为10的完全二叉树最少、最多有多少个结点？<br>
 * 推算：<br>
 * 深度为1的完全二叉树最少2^0+1=2，最多2^0+2^1=3。<br>
 * 深度为2的完全二叉树最少2^0+2^1+1=4，最多2^0+2^1+2^2=7。<br>
 * 深度为3的完全二叉树最少2^0+2^1+2^2+1=8，最多2^0+2^1+2^2+2^3=15。<br>
 * 深度为n的完全二叉树最少2^(n)，最多2^(n+1)-1个结点。<br>
 */
class CompleteBinaryTree
{}
