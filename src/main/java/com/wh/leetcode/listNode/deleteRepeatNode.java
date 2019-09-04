package com.wh.leetcode.listNode;

import java.util.*;

/**
 * @Auther: wwh
 * @Date: 2019-09-02 21:12
 * @Description:给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class deleteRepeatNode {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
//        node.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next =node5;
        deleteDuplicates(node);
        System.out.println();

    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            if(list.contains(head.val)){
                head = head.next;
                continue;
            }else {
                list.add(head.val);
            }
            head = head.next;
        }
        ListNode returnNode = new ListNode(0);
        for (int i = list.size()-1; i >=0; i--) {
            ListNode pNode=new ListNode(list.get(i));
            pNode.next=returnNode.next;
            returnNode.next=pNode;
        }
        return returnNode.next;
    }
}
