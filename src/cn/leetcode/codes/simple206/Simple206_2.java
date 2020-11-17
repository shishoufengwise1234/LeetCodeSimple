package cn.leetcode.codes.simple206;

import cn.leetcode.codes.common.ListNode;

public class Simple206_2 {


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            //暂存一下当前的节点
            ListNode temp = curr.next;

            //将当前节点后置数据 至为pre节点
            curr.next = pre;
            //pre 和 当前节点各向后移动一位
            pre = curr;
            curr = temp;
        }
        //最后pre 节点已移动至最后一个节点直接返回即可
        return pre;
    }
}
