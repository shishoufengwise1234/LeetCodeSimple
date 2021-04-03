package cn.leetcode.codes.simple24;

import cn.leetcode.codes.common.ListNode;

public class Simple24_2 {

    //递归解法
    public ListNode swapPairs(ListNode head) {
        //递归终止条件
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        //最终返回当前 head 的 下个节点
        return next;
    }


    //迭代解法
    public ListNode swapPairs2(ListNode head){
        //新建指针
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;

        while (temp.next != null && temp.next.next != null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;

            temp.next = end;
            start.next = end.next;
            end.next = start;

            //继续迭代
            temp = start;
        }
        return pre.next;
    }
}
