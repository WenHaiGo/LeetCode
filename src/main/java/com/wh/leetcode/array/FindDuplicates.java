package com.wh.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: wwh
 * @Date: 2019-09-30 22:15
 * @Description:
 */
public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        Set set = new HashSet();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int sizeTemp = set.size();
            set.add(num);
            if(sizeTemp==set.size()){
                list.add(num);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        FindDuplicates duplicates = new FindDuplicates();
        System.out.println(duplicates.findDuplicates(arr));
    }

}
