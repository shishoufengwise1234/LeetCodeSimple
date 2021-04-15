package cn.leetcode.codes.simple19;

import cn.leetcode.codes.CommonDataKt;
import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.ListNode;

public class Simple19 {


    public static void main(String[] args) {

        ListNode node = CommonDataKt.createListNode(1, 2, 3, 4, 5);
//        ListNode node = CommonDataKt.createListNode(1);
        PKt.outListNode(node);

//        ListNode re = new Simple19().removeNthFromEnd(node, 1);
        ListNode re2 = new Simple19_2().removeNthFromEnd(node, 1);
//        PKt.outListNode(re);
        PKt.outListNode(re2);

    }

    /*
    19. 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1,head);
        //计算链表长度
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        //移动节点将符合条件的数据加上
        ListNode curr = pre;
        for (int i = 0; i < length - n; ++i) {
            curr = curr.next;
        }
        //将后续链表数据连接上
        curr.next = curr.next.next;
        //返回后继指针
        return pre.next;
    }

}
