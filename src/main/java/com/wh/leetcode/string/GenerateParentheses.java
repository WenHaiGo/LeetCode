package com.wh.leetcode.string;


import com.wh.leetcode.stack.ValidbBrackets;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wwh
 * @Date: 2019/9/18 20:37
 * @Description: 2019年9月18日20:41:53
 */
public class GenerateParentheses {
    //生成所有排列
    public static void main(String[] args) {
        String temp = "123";
        char[] dd =  {'(',')',')','('};
        GenerateParentheses d = new GenerateParentheses();

        System.out.println(d.valid(dd));

        //getAllCombination(temp);
        List<String> sds = new ArrayList<>();
                d.generateAll(new char[2 * 3],0,sds);
        System.out.println(sds.toString());
    }
    /**
     *
     * @date: 2019/9/18 20:59
     * @param: * @param current:
     * @return: * @return: boolean
     * @author: wwh
     * @Description:   这个算法来判断是否为有效地括号简直就是漂亮啊卧槽
     */
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }


    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    private static List<String> getAllCombination(String temp) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < temp.length(); i++) {
            for (int j = 0; j < temp.length(); j++) {
                if(i!=j){
                    System.out.println(temp.charAt(i)+"==="+temp.charAt(j));
                    list.add(i+""+j);
                }

            }
        }
        return list;
    }



}
