package cn.leetcode.codes.simple2;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.ListNode;

import javax.print.attribute.standard.OrientationRequested;

public class Simple2_2 {

     /**
       *
       * 刷题情况
       *
       * 题目地址：
      *
      * 题解地址:
      *
      * https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
       *
       * 1 刷是否通过：no
       *
       *
       * 2 刷是否完成：no
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
       *
       *
       */

    public static void main(String[] args){

        ListNode l1 = new ListNode(2);
        ListNode l1Mid = new ListNode(4);
        ListNode l1Last = new ListNode(3);

        l1Last.next = null;
        l1Mid.next = l1Last;
        l1.next = l1Mid;


        ListNode l2 = new ListNode(5);
        ListNode l2Mid = new ListNode(6);
        ListNode l2Last = new ListNode(4);

        l2Last.next = null;
        l2Mid.next = l2Last;
        l2.next = l2Mid;

        PKt.outListNode(l1);
        PKt.outListNode(l2);

        ListNode re = new Simple2_2().addTwoNumbers(l1,l2);

        PKt.outListNode(re);

    }

    /*

    2. 两数相加
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807


     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);

        ListNode pro = listNode;
        int curr = 0;

        while (l1 != null || l2 != null){
            //取出两个链表的数据
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + curr;
            //得出进位数据
            curr = sum / 10;
            // 得出当前位置 数值和
            sum = sum % 10;

            pro.next = new ListNode(sum);
            pro = pro.next;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (curr == 1){
            pro.next = new ListNode(curr);
        }


        return listNode.next;
    }

}
