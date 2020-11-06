package cn.leetcode.codes.offer.o24;

import cn.leetcode.codes.CommonDataKt;
import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.ListNode;

public class Offer24 {

    public static void main(String[] args) {

        ListNode listNode = CommonDataKt.createListNode(1,2,3,4,5);
        PKt.outListNode(listNode);

        PKt.out("开始翻转链表...");
        new Offer24().reverseList(listNode);

        PKt.outListNode(listNode);

    }

    /*
    剑指 Offer 24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。


示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL


限制：

0 <= 节点个数 <= 5000



注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
     */
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pro = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;

            //完成一次局部交换,最终将 Pro 指针移动到链表尾部 完成链表翻转
            curr.next = pro;
            pro = curr;

            curr = temp;
        }
        return pro.next;
    }
}
