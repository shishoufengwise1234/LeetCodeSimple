package cn.leetcode.codes.interview;

import cn.leetcode.codes.common.ListNode;

public class Inter0203 {


    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/delete-middle-node-lcci/
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


    public static void main(String[] args) {


    }


    /*
    面试题 02.03. 删除中间节点
实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。

示例：

输入：单向链表a->b->c->d->e->f中的节点c
结果：不返回任何数据，但该链表变为a->b->d->e->f
     */

    public void deleteNode(ListNode node) {
        if (node == null){
            return;
        }
        //计算长度
        int count = 0;
        ListNode curr = node;
        while (curr != null){
            count++;
            curr = curr.next;
        }


    }


}
