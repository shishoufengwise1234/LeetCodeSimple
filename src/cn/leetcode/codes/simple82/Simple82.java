package cn.leetcode.codes.simple82;

import cn.leetcode.codes.CommonDataKt;
import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.ListNode;

public class Simple82 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
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
     *
     * 面试是否遇到过？
     *
     *
     * 企业：
     *
     *
     *
     *
     */

    public static void main(String[] args) {

        ListNode node = CommonDataKt.createListNode(1,2,3,3,4,4,5);

        ListNode re = new Simple82().deleteDuplicates(node);

        PKt.outListNode(re);



    }

    /*
    存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。

返回同样按升序排列的结果链表。

 

示例 1：


输入：head = [1,2,3,3,4,4,5]
输出：[1,2,5]
示例 2：


输入：head = [1,1,1,2,3]
输出：[2,3]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode node = new ListNode(0,head);

        ListNode curr = node;
        while (curr.next != null && curr.next.next != null){
            //发现重复元素
            if (curr.next.val == curr.next.next.val) {
                int x = curr.next.val;
                //将重复元素全部删除
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            }else{
                curr = curr.next;
            }
        }
        return node.next;
    }



}
