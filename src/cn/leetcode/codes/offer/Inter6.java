package cn.leetcode.codes.offer;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.ListNode;

import java.util.Arrays;

public class Inter6 {


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);

        h5.next = null;
        h4.next = h5;
        h3.next = h4;
        h2.next = h3;
        head.next = h2;

        PKt.outListNode(head);

        PKt.out("----------");

        int[] re = new Inter6().reversePrint(head);
        PKt.out(Arrays.toString(re));


    }

    /*
    面试题06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



示例 1：


输入：head = [1,3,2]
输出：[2,3,1]


限制：

0 <= 链表长度 <= 10000
     */

    public int[] reversePrint(ListNode head) {
        ListNode curr = head;
        int index = 0;
        while (curr != null){
            curr = curr.next;
            index++;
        }
        int[] arr = new int[index];

        while (head != null){
            arr[index - 1] = head.val;
            index--;
            head = head.next;
        }
        return arr;
    }


}
