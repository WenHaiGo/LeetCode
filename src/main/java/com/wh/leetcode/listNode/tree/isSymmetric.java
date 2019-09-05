package com.wh.leetcode.listNode.tree;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @Auther: wwh
 * @Date: 2019-09-05 21:23
 * @Description:
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class isSymmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(4);

        root.left = treeNode2;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        root.right = treeNode3;
        treeNode3.left = treeNode7;
        treeNode3.right = treeNode6;

        System.out.println(isMirror(root,root));


    }
    /**
     * 
     * @date: 2019-09-05 21:56
     * @param: * @param t1: 
      * @param node2:
     * @return: * @return: boolean
     * @author: wwh 
     * @Description:      
     */       
    public static boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        return (node1.val == node2.val)
                && isMirror(node1.right, node2.left)
                && isMirror(node1.left, node2.right);

        //这里没有明白为甚要用俩个递归？？
    }
}
