package cn.leetcode.codes.simple21;

import cn.leetcode.codes.common.ListNode;

public class Simple21_3 {


    //循环写法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //新的链表
        ListNode pre = new ListNode(-1);
        ListNode curr = pre;
        //两个链表都不为null时往下循环
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
        //两个链表长度不同可能导致没有添加完全
        curr.next = l1 == null ? l2 : l1;
        return pre.next;
    }

    //递归写法
    public ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }
}