package cn.leetcode.codes.simple21;

import cn.leetcode.codes.common.ListNode;

public class Simple21_2 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(-1);
        ListNode curr = pre;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return pre.next;
    }

    //递归解法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l1,l2.next );
            return l2;
        }
    }

}
