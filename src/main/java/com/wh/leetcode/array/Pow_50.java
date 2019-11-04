package com.wh.leetcode.array;

/**
 * @Auther: wwh
 * @Date: 2019/10/3 22:14
 * @Description:
 */
public class Pow_50 {

    private double fastPow(double x, long n) {
        if(n==0){
            return 1;
        }

        double half =  fastPow(x,n/2 );
        if(n%2==0){
            return half*half;
        }else {
            return half*half*x;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    public static void main(String[] args) {
        Pow_50 pow_50 = new Pow_50();
        System.out.println(pow_50.fastPow(10, 2));
    }


}
