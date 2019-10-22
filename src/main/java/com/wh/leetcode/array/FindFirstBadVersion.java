package com.wh.leetcode.array;

import javax.sound.midi.InvalidMidiDataException;

/**
 * @Auther: wwh
 * @Date: 2019/10/21 18:59
 * @Description:
 */
public class FindFirstBadVersion {

    //二分法
    public int firstBadVersion(int n) {
        if (n < 1) {
            return 0;
        }
        int  start = 0,end = n,mid=0;

        //为什么start<end  就会出现超时？
        while(start+1<end){
            //每次都取中间的数字
            mid = start+(end-start)/2;
            //如果这个是坏的 说明前面仍然可能有坏的所以把这个作为终点  反之如果这个是好的 那么就把这个作为起点继续遍历
            if(isBadVersion(mid)){
                end = mid;
            }else {
                start = mid;
            }
        }

        //处理如果第一个是坏的情况
        if(isBadVersion(start)) {
            return start;
        }
        //处理最后一个坏的情况
        if(isBadVersion(end)) {
            return end;
        }
        return 0;
    }



    public static int binarySearch(int[] arr,int target){
        int  low = 0,hi = arr.length,mid=hi;
        while(low<=hi){
            mid= (hi+low)/2;
            if(arr[mid]>target){
                hi =mid-1;
                continue;
            }
            else if(arr[mid]<target){
                low =  mid+1;
                continue;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    public boolean isBadVersion(int version){
        return true;
    }

    public static void main(String[] args) {
        int[] arr  =  {1,2,3,4,5,6};
        System.out.println(binarySearch(arr, 6));
    }
}
