package cn.leetcode.codes.simple21;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.ListNode;

import java.util.List;

public class Simple21 {


    public static void main(String[] args) {

        PKt.out("main start ");

        ListNode li1 = new ListNode(1);
        ListNode li2 = new ListNode(2);
        ListNode li4 = new ListNode(4);

        ListNode ni1 = new ListNode(1);
        ListNode ni3 = new ListNode(3);
        ListNode ni4 = new ListNode(4);


        li2.next = li4;
        li1.next = li2;

        ni3.next = ni4;
        ni1.next = ni3;

        PKt.outListNode(li1);
        PKt.outListNode(ni1);

//        ListNode newNode = new Simple21().mergeTwoLists(li1,ni1);
        ListNode newNode = new Simple21().mergeTwoLists2(li1,ni1);

        PKt.outListNode(newNode);

    }




    /*

    21. 合并两个有序链表

    将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode reNode = l1;

        while (l2.next != null){
            while (reNode.next != null){
                if (reNode.val > l2.val){
                    l2.next = reNode;
                }else{
                    reNode.next = l2;
                }
                reNode = reNode.next;
            }
            //继续下一个匹配
            l2 = l2.next;
        }

        PKt.outListNode(reNode);

        return reNode;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 创建一个用于比较的前置指针
        ListNode reNode = new ListNode(-1);

        // 虚拟的 前置指针
        ListNode prev = reNode;

//        PKt.outListNode(prev);

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

//        PKt.outListNode(l1);
//        PKt.outListNode(l2);
//
//        PKt.outListNode(prev);

        // 最后一步 需要计算出尾部指针
        prev.next = l1 == null ? l2 : l1;

        return reNode.next;

    }
}
