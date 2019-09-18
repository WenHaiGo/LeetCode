package com.wh.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wwh
 * @Date: 2019-09-14 16:00
 * @Description:
 *
 *Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 思路
 * 因为题目要求元素可以重复，所以使用了递归，挨个遍历去寻找所有的可能性，递归的终止条件有俩个，如果大于目标值，表明当前下标元素没有可能，如果等于将当前组合添加到全局变量中。继续下个下标。
 */
public class CombinationSum {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            addElement(candidates, list, sum, target,0);
            return res;

        }

        private void addElement(int[] candidates, List<Integer> list, int sum, int target,int index) {
            if (sum > target)
                return;
            if (sum == target) {
                res.add(list);
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                List<Integer> tempList = new ArrayList<>(list);
                tempList.add(candidates[i]);
                addElement(candidates, tempList, sum + candidates[i], target,i);
            }

        }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] nums = {2,3,6,7};
        List<List<Integer>> lists  =  combinationSum.combinationSum(nums,7);

    }

}
