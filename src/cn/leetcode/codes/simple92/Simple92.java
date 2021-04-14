package cn.leetcode.codes.simple92;

import cn.leetcode.codes.CommonDataKt;
import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.ListNode;

public class Simple92 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/reverse-linked-list-ii/
     *
     * 1 刷是否通过：没有
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

        int left = 2,right = 4;

        ListNode node = CommonDataKt.createListNode(1,2,3,4,5);

        ListNode re = new Simple92().reverseBetween(node, left, right);

        PKt.outListNode(re);

    }

    /*
    给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 

示例 1：


输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
示例 2：

输入：head = [5], left = 1, right = 1
输出：[5]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null){
            return null;
        }
        if (left >= right){
            return head;
        }
        ListNode childNode = new ListNode(-1,head);

        ListNode pre = childNode;

        //找出需要翻转的子串开始位置
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        //找到翻转子串的结束位置
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        //区间链表
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        //切断链表
        pre.next = null;
        rightNode.next = null;

        //翻转区间链表
        reverseListNode(leftNode);

        //将链表重新连接起来
        pre.next = rightNode;
        leftNode.next = curr;

        return childNode.next;
    }

    private void reverseListNode(ListNode leftNode) {
        ListNode pre = null;
        ListNode curr = leftNode;

        while (curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;

            curr = temp;
        }
    }
}
