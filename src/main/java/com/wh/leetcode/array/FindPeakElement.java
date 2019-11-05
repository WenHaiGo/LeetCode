package com.wh.leetcode.array;

/**
 * @Auther: wwh
 * @Date: 2019-10-23 00:02
 * @Description:
 *
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length<0){
            return 0;
        }
        int start = 0,end = nums.length;
        //因为俩个数相除最小间距是1
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //每次都在中间寻找，
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
                //如果中间的比左边的大 但是右边的比左边的也大 说明peak在右边，所以把当前的作为起始点
            } else if (nums[mid - 1] < nums[mid]) {
                start = mid;
                //如果中间的比左边的小，而且右边的更小，说明peak在左边  所以把mid 看成end元素
            } else {
                end = mid;
            }
        }

        if (nums[start] > nums[end]) {
            return start;
        } else {
            return end;
        }
    }


}
