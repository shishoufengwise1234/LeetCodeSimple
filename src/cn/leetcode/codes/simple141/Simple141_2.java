package cn.leetcode.codes.simple141;

import cn.leetcode.codes.common.ListNode;

public class Simple141_2 {


    //快慢指针思想
    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null) return false;

        ListNode fast = head.next;
        ListNode slow = head;

        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
