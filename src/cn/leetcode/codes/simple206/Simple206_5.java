package cn.leetcode.codes.simple206;

import cn.leetcode.codes.common.ListNode;

public class Simple206_5 {


    //翻转链表
    public ListNode reverseList(ListNode head){
        if (head == null) return null;

        ListNode p = null;
        ListNode curr = head;

        while (curr != null){
            //保存当前节点
            ListNode temp = curr.next;

            //交换指针
            curr.next = p;
            p = curr;

            curr = temp;
        }
        return p;
    }
}
