package cn.leetcode.codes.simple142;

import cn.leetcode.codes.common.ListNode;

import java.util.HashSet;

public class Simple142 {


    public static void main(String[] args) {


    }

    //哈希表
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }




    //快慢指针
    public ListNode detectCycle2(ListNode head){
        //无环
        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null){
            //到达尾部 不存在环
            if (fast.next == null){
                return null;
            }else {
                fast = fast.next.next;
            }
            slow = slow.next;

            //存在环
            if (slow == fast){
                //存在环的情况下 需要从头遍历 查找出节点
                ListNode pre = head;
                while (pre != slow){
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }
        }
        return null;
    }

}
