package cn.leetcode.codes.study.node;

public class TwoNode<E> {

    public E data;
    // 前置节点
    public TwoNode<E> pre;
    //后置节点
    public TwoNode<E> next;

    public TwoNode(){
    }

    public TwoNode(E d){
        data = d;
        pre = null;
        next = null;
    }

    @Override
    public String toString() {
        return "TwoNode{" +
                "data=" + data +
                ", pre=" + pre +
                ", next=" + next +
                '}';
    }
}
