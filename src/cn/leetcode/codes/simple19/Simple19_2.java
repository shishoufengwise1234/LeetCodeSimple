package cn.leetcode.codes.simple19;

import cn.leetcode.codes.common.ListNode;

public class Simple19_2 {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        ListNode pre = new ListNode(-1,head);

        //计算链表长度
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }

        ListNode curr = pre;
        for (int i = 0; i < length - n; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return pre.next;
    }

}
