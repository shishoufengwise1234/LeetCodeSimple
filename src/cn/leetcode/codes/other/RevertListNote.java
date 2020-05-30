package cn.leetcode.codes.other;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.ListNode;

public class RevertListNote {


    public static void main(String[] args){


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


        PKt.out("翻转之前 ----");
        PKt.outListNode(head);

        PKt.out("翻转之后 ----");
        head = revert(head);

        PKt.outListNode(head);
    }


    public static ListNode revert(ListNode head){

        ListNode pre = null,next;
        while (head != null){
            next = head.next;   //①
            head.next = pre;    //②
            pre = head;     //③
            head = next;    //④
        }
        return pre;
    }


}
