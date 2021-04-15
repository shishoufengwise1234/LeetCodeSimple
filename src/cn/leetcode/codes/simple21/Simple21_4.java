package cn.leetcode.codes.simple21;

import cn.leetcode.codes.common.ListNode;

public class Simple21_4 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        ListNode ans = new ListNode(-1);
        ListNode curr = ans;

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
        //优化写法
        curr.next = l1 == null ? l2 : l1;

        return ans.next;
    }
}
