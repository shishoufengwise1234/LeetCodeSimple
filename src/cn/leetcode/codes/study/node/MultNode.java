package cn.leetcode.codes.study.node;

public class MultNode {

    public String data;
    // 前置节点
    public MultNode pre;
    //后置节点
    public MultNode next;

    public MultNode(){

    }

    public MultNode(String d){
        data = d;
        pre = null;
        next = null;
    }
}
