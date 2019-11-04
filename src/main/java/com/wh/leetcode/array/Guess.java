package com.wh.leetcode.array;

import com.sun.imageio.plugins.common.BogusColorSpace;

/**
 * @Auther: wwh
 * @Date: 2019/10/5 19:08
 * @Description:
 */
public class Guess {
    public int game(int[] guess, int[] answer) {
        int res = 0;
        for (int i = 0;i< guess.length;i++) {
            if(guess[i]==answer[i]){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Guess guess  = new Guess();
        int[] a = {1,2,3};
        int[] b = {1,2,3};
        System.out.println(guess.game(a, b));
    }

}
