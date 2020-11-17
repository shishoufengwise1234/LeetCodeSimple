package cn.leetcode.codes.interview;

import cn.leetcode.codes.common.ListNode;

import java.util.HashSet;

public class Inter0201 {


    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
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
     */





    /*
    面试题 02.01. 移除重复节点
编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

示例1:

 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
示例2:

 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
提示：

链表长度在[0, 20000]范围内。
链表元素在[0, 20000]范围内。
进阶：

如果不得使用临时缓冲区，该怎么解决？
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null){
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);

        ListNode pre = head;

        return pre;
    }



}

