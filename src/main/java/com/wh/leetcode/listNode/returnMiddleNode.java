package com.wh.leetcode.listNode;

import com.sun.source.tree.WhileLoopTree;

/**
 * @Auther: wwh
 * @Date: 2019-09-03 22:25
 * @Description:
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *  
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class returnMiddleNode {
    //思路就是求出链表的长度，然后再取出特定的值
    public static ListNode middleNode(ListNode head) {
        if(head==null){
            return null;
        }
        int length = 0;
        int index = 0;
        ListNode tempNode = head;
        while(tempNode!=null){
            length++;
            tempNode = tempNode.next;
        }
        index = length/2+1;
        int temp =  0;
        while (head!=null){
            temp++;
            if(temp==index){
                return head;
            }
            head = head.next;

        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = null;
        System.out.println(middleNode(node).val);
        System.out.println(5/2);
    }
}
