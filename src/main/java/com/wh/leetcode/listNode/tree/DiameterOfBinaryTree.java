package com.wh.leetcode.listNode.tree;

import sun.jvm.hotspot.debugger.MachineDescription;
import sun.tools.jconsole.MaximizableInternalFrame;

import java.awt.*;

/**
 * @Auther: wwh
 * @Date: 2019-09-06 21:52
 * @Description:
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


//LeetCode好像有bug  方法用static  定义了之后一个只有一个根节点的用例就算错了，而我本地跑那个例子就没问题
public class DiameterOfBinaryTree {
    static int maxDepth = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root!=null){
            getDepth(root);
            return maxDepth;

        }
        return 0;
    }

    public static int getDepth(TreeNode root) {
       //递归的终止条件
        if(root!=null){
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            maxDepth = Math.max(maxDepth, leftDepth +rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;
        }
        return 0;

    }







    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(4);

        /*root.left = treeNode2;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        root.right = treeNode3;
        treeNode3.left = treeNode7;
        treeNode3.right = treeNode6;*/

        int  a  = diameterOfBinaryTree(root);
        System.out.println(a);
    }
}
