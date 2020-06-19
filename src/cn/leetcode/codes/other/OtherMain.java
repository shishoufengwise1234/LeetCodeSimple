package cn.leetcode.codes.other;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.ListNode;
import sun.awt.datatransfer.DataTransferer;

import java.util.Arrays;

public class OtherMain {


    public static void main(String[] args){

        PKt.out(""+(2 << 1));  //左移进行乘 2
        PKt.out(""+(2 >> 1));  //右移进行除 2

//        OtherMain main = new OtherMain();
//
//        int[] ins = {-1,0,5,2,8,0,0,0,5,-1,98,0,0,56};
//        int[] reIns = main.sufferList(ins);
//
//        PKt.out(Arrays.toString(reIns));

        System.out.println("结果："+1/0);
        System.out.println("结果："+1.0/0);

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

        PKt.out("-----------------");

        ListNode re = new OtherMain().resetListNode(head);
        PKt.outListNode(re);
    }


    public ListNode resetListNode(ListNode head){
        ListNode pre = null;
        ListNode next = null;

        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }




    /*

    要求 [5,2,8,0,0,0,5]
    输出：[5,2,8,5,0,0,0]

    非零数据位置不动
     */
    public int[] sufferList(int[] ints){
//        int[] newInts = new int[ints.length];
        int pos = 0;
//        for (int anInt : ints) {
//            if (anInt != 0) {
//                newInts[pos] = anInt;
//                pos++;
//            }
//        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0){
                int temp = ints[i];
                ints[i] = ints[pos];
                ints[pos] = temp;
                pos++;
            }
        }
//        return newInts;
        return ints;
    }
}
