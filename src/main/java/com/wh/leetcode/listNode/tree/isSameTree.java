package com.wh.leetcode.listNode.tree;

/**
 * @Auther: wwh
 * @Date: 2019-09-04 20:29
 * @Description:
 */
public class isSameTree {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null){
            return false;
        }
        if(q==null){
            return false;
        }

        return false;
    }
}
