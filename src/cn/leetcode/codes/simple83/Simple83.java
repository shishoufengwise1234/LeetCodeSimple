package cn.leetcode.codes.simple83;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.ListNode;

public class Simple83 {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);

        node3.next = null;
        node2.next = node3;
        node1.next = node2;

        PKt.outListNode(node1);

        ListNode node = new Simple83().deleteDuplicates(node1);
        PKt.outListNode(node);
    }

    /*
    83. 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3
     */

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null){
            if (curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return head;
    }

}
