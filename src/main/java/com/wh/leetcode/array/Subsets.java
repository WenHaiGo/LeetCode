package com.wh.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wwh
 * @Date: 2019/9/22 18:54
 * @Description:
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * dfs
 * 思路：
 * 递归实现。
 * 开始执行一次深度优先遍历，一直到底，然后原路返回继续寻找其他的元素
 *
 */
public class Subsets {


    /**
     *
     * @date: 2019/9/22 19:00
     * @param: * @param nums:
     * @return: * @return: java.util.List<java.util.List<java.lang.Integer>>
     * @author: wwh
     * @Description:   思路： 1、从元素个数出发
     *                          子集元素个数为1，2。。。
     *
     */
    /*public List<List<Integer>> getSubsets(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list  = getSubsetsByEleNum(nums,i+1);
        }
        return null;
    }

    private List<Integer> getSubsetsByEleNum(int[] nums, int i) {
        //其实就是转换为了求组合数 1 2 3 4 5  c（5，n）是下标
        //但是c(n,k)的算法我也写不出啊
        for (int j = 0; j < nums.length; j++) {
            for(int k = j+1;k<nums.length;k++){

            }
        }
        return null;
    }


    public static void main(String[] args) {

    }
*/

    private List<List<Integer>> res;

    private void dfs(int[] nums, int begin, List<Integer> pre) {
        // for 循环就是递归终止条件
        res.add(new ArrayList<>(pre));
        for (int i = begin; i < nums.length; i++) {
            pre.add(nums[i]);
            dfs(nums, i + 1, pre);
            pre.remove(pre.size() - 1);// 返回上一层
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        List<Integer> pre = new ArrayList<>();
        dfs(nums, 0, pre);
        return res;
    }
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>>  lists = subsets.subsets(nums);
        System.out.println();
    }




}
