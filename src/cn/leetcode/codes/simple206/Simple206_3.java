package cn.leetcode.codes.simple206;

import cn.leetcode.codes.common.ListNode;

public class Simple206_3 {


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            //把下一个节点先暂存起来
            ListNode temp = curr.next;
            //将pre指针指向 当前节点下一个
            curr.next = pre;
            //将当前节点指向 前进指针
            pre = curr;
            //继续将后遍历
            curr = temp;
        }
        return pre;
    }
}