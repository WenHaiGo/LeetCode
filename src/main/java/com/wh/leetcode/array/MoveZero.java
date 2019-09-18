package com.wh.leetcode.array;

/**
 * @Auther: wwh
 * @Date: 2019-09-12 22:55
 * @Description:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 2019年09月12日22:56:38
 * 思路1：新建一个数组 遍历原数组，把非零的放进去就可以了
 * 是否可以使用冒泡法来做？把0都冒出来？
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZero moveZero  = new MoveZero();
        moveZero.moveZeros(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void moveZeros(int[] nums){
        if(nums==null){
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==0){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }






}
