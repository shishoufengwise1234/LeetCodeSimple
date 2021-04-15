package cn.leetcode.codes.simple24;

import cn.leetcode.codes.CommonDataKt;
import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.ListNode;

public class Simple24 {

    /**
     * 刷题情况
     *
     * 题目地址： https://leetcode-cn.com/problems/swap-nodes-in-pairs/
     *
     * 1 刷是否通过：没有
     *
     *
     * 2 刷是否完成：没有
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
     * 最优解析：https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/hua-jie-suan-fa-24-liang-liang-jiao-huan-lian-biao/
     *
     */

    public static void main(String[] args) {

        ListNode node = CommonDataKt.createListNode(1,2,3,4);
        PKt.outListNode(node);

//        ListNode re = new Simple24().swapPairs(node);
//        PKt.outListNode(re);

//        Simple24_2 simple24_2 = new Simple24_2();
//        ListNode re = simple24_2.swapPairs(node);
//        ListNode re = simple24_2.swapPairs2(node);
//        PKt.outListNode(re);

        Simple24_3 simple24_3 = new Simple24_3();
        ListNode re3 = simple24_3.swapPairs(node);

        PKt.outListNode(re3);


    }

    /*
    24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。


示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]


提示：

链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100
     */

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newNext = head.next;
        head.next = swapPairs(newNext.next);
        newNext.next = head;
        return newNext;
    }

}
