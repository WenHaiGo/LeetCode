package top100;

/**
 * @Auther: wwh
 * @Date: 2019/11/5 21:10
 * @Description: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 * 例如：
 * <p>
 * 输入: 二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 * <p>
 * 二叉搜索树：
 * 叉搜索树是一种节点值之间具有一定数量级次序的二叉树，对于树中每个节点：
 * 若其左子树存在，则其左子树中每个节点的值都不大于该节点值；
 * 若其右子树存在，则其右子树中每个节点的值都不小于该节点值。--https://www.jianshu.com/p/ff4b93b088eb
 * <p>
 * ？？
 * 1、题目读懂了，但是还是不会遍历树
 * ！！
 * 看代码想到的是：
 * 1、二叉搜索树的定义出发  把右子树的每个节点都加到该节点
 * 2、BST的中序遍历就是从小到大,那么反过来就是从大到小,然后累加就好了.参考-leetcode 讨论区
 * 学到了
 * 二叉树的遍历又忘了，应该把二叉树的遍历方式都背会
 */
public class ConvertBstToGreaterTree {
    public int sum = 0;

    void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            helper(root.right);
        }

        root.val = (sum += root.val);
        if (root.left != null) {
            helper(root.left);
        }
    }

    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
}
