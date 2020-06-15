package cn.leetcode.codes.simple206;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.ListNode;


public class Simple206 {

    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/reverse-linked-list/
     * <p>
     * 1 刷是否通过：no
     * <p>
     * <p>
     * 2 刷是否完成：
     * <p>
     * <p>
     * 3 刷是否完成：
     * <p>
     * <p>
     * 4 刷是否完成：
     * <p>
     * <p>
     * 5 刷是否完成：
     */


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);

        h5.next = null;
        h4.next = h5;
        h3.next = h4;
        h2.next = h3;
        head.next = h2;

        PKt.outListNode(head);

        PKt.out("----------");

        ListNode re = new Simple206().reverseList(head);

        PKt.outListNode(re);

    }

    /*
206. 反转链表
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？


     */

    public ListNode reverseList(ListNode head) {
        ListNode pro = null,curr = head;
        while (curr != null){
            ListNode temp = curr.next;

            curr.next = pro;
            pro = curr;

            curr = temp;
        }
        return pro;
    }

}
