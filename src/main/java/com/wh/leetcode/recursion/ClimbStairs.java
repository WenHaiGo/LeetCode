package com.wh.leetcode.recursion;

import javax.swing.text.rtf.RTFEditorKit;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: wwh
 * @Date: 2019/10/7 20:50
 * @Description:
 */
public class ClimbStairs {
    //为了避免每次重复计算 保存每次计算结果
    Map<Integer,Integer> calResult = new HashMap<>();
    public int climbStairs(int n) {
        if(n==1){
            return  1;
        }
        if(n == 2){
            return 2;
        }
        if(calResult.containsKey(n)){
            return calResult.get(n);
        }

        int temp = climbStairs(n - 1) + climbStairs(n - 2);
        calResult.put(n, temp);
        return temp;
    }

    public static void main(String[] args) {
        ClimbStairs stairs  =  new ClimbStairs();
        System.out.println(stairs.climbStairs(3));
    }
}
