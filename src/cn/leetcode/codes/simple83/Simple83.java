package cn.leetcode.codes.simple83;

import cn.leetcode.codes.CommonDataKt;
import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.ListNode;

public class Simple83 {


    public static void main(String[] args) {

        ListNode node = CommonDataKt.createListNode(1,1,2);

//        ListNode re = new Simple83().deleteDuplicates(node);
//        PKt.outListNode(re);

        ListNode re2 = new Simple83_2().deleteDuplicates(node);
        PKt.outListNode(re2);

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
