package cn.leetcode.codes.simple203;

import cn.leetcode.codes.CommonDataKt;
import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.ListNode;

public class Simple203 {

    /**
     * 刷题情况
     *
     * 题目地址： https://leetcode-cn.com/problems/remove-linked-list-elements/
     *
     * 1 刷是否通过：
     *
     *
     * 2 刷是否完成：
     *
     *
     * 3 刷是否完成：
     *
     *
     * 4 刷是否完成：
     *
     *
     * 5 刷是否完成：
     *
     * 最优解析：
     *
     */

    public static void main(String[] args) {

        ListNode node = CommonDataKt.createListNode(1,2,6,3,4,5,6);
        PKt.outListNode(node);

        ListNode re = new Simple203().removeElements(node, 6);
        PKt.outListNode(re);


    }

    /*
    203. 移除链表元素
删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
     */

    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode curr = head;
        while (head != null){
            if (head.val == val){
                ListNode temp = head.next;
                while (temp != null && temp.val != val){
                    temp = temp.next;
                }
                curr.next = temp;
            }
            head = head.next;
        }
        return curr;
    }
}
