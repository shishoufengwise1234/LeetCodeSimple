package cn.leetcode.codes.simple206;

import cn.leetcode.codes.common.ListNode;

public class Simple206_4 {


    // 反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        //当前链表
        ListNode curr = head;
        //新链表
        ListNode prev = null;

        while (curr != null){
            //暂存 当前节点
            ListNode temp = curr.next;

            //交换两个指针
            curr.next = prev;
            //将当前节点赋值给 新链表节点
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
