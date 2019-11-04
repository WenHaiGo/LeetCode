package com.wh.leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: wwh
 * @Date: 2019/9/25 21:01
 * @Description:  求全排列：
 * 思路1。使用回溯法解决  个人理解回溯法就是有方向的遍历所有情况
 * 2、使用一个数组来存每个元素是否使用过，这样可以避免元素重复
 * 3、回溯法要记得做状态重置。
 */
public class Permutation {
        // curSize 表示当前的路径 path 里面有多少个元素 used  标记下标元素是否使用过，
        private void generatePermution(int[] nums, boolean[] used, int curSize, int len, Stack<Integer> path, List<List<Integer>> res) {
            if (curSize == len) {
                // 此时 path 已经保存了 nums 中的所有数字，已经成为了一个排列
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    path.push(nums[i]);
                    used[i] = true;
                    generatePermution(nums, used, curSize + 1, len, path, res);
                    // 回溯的时候，状态重置
                    path.pop();
                    used[i] = false;
                }
            }
        }

        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            boolean[] used = new boolean[len];
            if (len == 0) {
                return res;
            }
            generatePermution(nums, used, 0, len, new Stack<>(), res);
            return res;
        }

        public static void main(String[] args) {
            int[] nums = new int[]{1, 2};
            Permutation solution = new Permutation();
            List<List<Integer>> permute = solution.permute(nums);
            int  i = 0;
            for (; i < permute.size(); i++) {
                System.out.println(permute.get(i));
            }

            int j = 0;
            for (; j <= 10; j++) {
                System.out.println(j);
            }
        }
}
