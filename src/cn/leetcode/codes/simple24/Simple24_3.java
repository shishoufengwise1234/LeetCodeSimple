package cn.leetcode.codes.simple24;

import cn.leetcode.codes.common.ListNode;

public class Simple24_3 {

    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = new ListNode(-1,head);

        ListNode temp = pre;

        while (temp.next != null && temp.next.next != null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;

            temp.next = end;
            start.next = end.next;
            end.next = start;

            temp = start;
        }

        return pre.next;
    }

}
