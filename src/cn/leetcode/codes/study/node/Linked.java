package cn.leetcode.codes.study.node;

import cn.leetcode.codes.PKt;

/**
 *
 * 单链表实现
 *
 * @param <E> 数据
 */
public class Linked<E> {

    private Link<E> mHead;
    private transient int mSize;

    public Linked(){
        this.mHead = null;
        this.mSize = 0;
    }

    /**
     *
     * 当前链表中 数据是否是空的
     *
     * @return true 链表数据为空 false 链表数据不为空
     */
    public boolean isEmpty(){
        return mSize > 0;
    }

    /**
     *
     * 当前链表 的大小
     *
     * @return 链表大小
     */
    public int size(){
        return this.mSize;
    }

    /**
     *
     * 添加 首位节点数据
     *
     * @param e 数据
     */
    public void addFirst(E e){
        PKt.out("addFirst() e = "+e);

        Link<E> newLink = new Link<>(e);
        newLink.next = this.mHead;

        // 设置新的 节点指针
        this.mHead = newLink;

        this.mSize++;
    }

    /**
     *
     * 添加末尾 数据
     *
     * @param e 数据
     */
    public void addLast(E e){
        PKt.out("addLast() e = "+e + " mSize = "+mSize);

        add(this.mSize,e);
    }

    /**
     *
     * 在指定位置添加数据
     *
     * @param pos 指定位置
     * @param e 数据
     */
    public void add(int pos,E e){
        checkPos(pos);

        PKt.out("add() pos = "+pos);

        // 如果是插入下标 小于 0 则认为插入头部
        if (pos == 0){
            addFirst(e);
        }
        Link<E> curr = this.mHead;
        int count = 0;

        for (int i = 0; i < pos - 1; i++) {
            curr = curr.next;
        }

//        while (curr.next != null) {
//            if (count == pos - 1) {
//                break;
//            }
//            curr = curr.next;
//            count++;
//        }
        Link<E> newLink = new Link<>(e);
        newLink.next = curr.next;
        curr.next = newLink;

        this.mSize++;
    }

    /**
     *
     * 删除指定数据
     *
     * @param e 数据
     */
    public void remove(E e){
        if (this.mHead == null){
            throw new IllegalArgumentException("mHead is null");
        }
        PKt.out("remove() e = "+e);

        // 如果删除的数据是 头部 先删除头部数据
        while (this.mHead.data != null && this.mHead.data.equals(e)){
            this.mHead = this.mHead.next;
            this.mSize--;
        }
        // 移除后续数据
        Link<E> curr = this.mHead;
        while (curr.next != null){
            if (curr.data != null && curr.data.equals(e)){
                curr = curr.next;
                this.mSize--;
            }else{
                curr = curr.next;
            }
        }
    }

    /**
     *
     * 检查 pos 下标是否正确
     *
     * @param pos 要操作的下标
     */
    public void checkPos(int pos){
        if (pos < 0 || pos > mSize) throw new IllegalArgumentException("this pos error");
    }

    public Link<E> findLink(int pos){
        checkPos(pos);

        PKt.out("findLink() pos = "+pos);

        if (pos <= 0){
            return mHead;
        }
        Link<E> curr = this.mHead;
        int count = -1;
        while (curr.next != null){
            if (count == pos - 1){
                return curr;
            }
            count++;
            curr = curr.next;
        }
        return null;
    }

    /**
     *
     * 判断一个数据 是否已经存在
     *
     * @param e 数据
     * @return true 已存在 false 不存在
     */
    public boolean contains(E e){
        PKt.out("contains e = "+e);

        Link<E> curr = this.mHead;
        while (curr.next != null){
            if (curr.data != null && curr.data.equals(e)){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }




    public String outString(){
        StringBuilder sb = new StringBuilder();

        sb.append("count: ")
                .append(size())
                .append(" data : ");

        Link<E> curr = this.mHead;
        do {
            sb.append(curr)
                    .append(" > ");
            curr = curr.next;
        }
        while (curr != null && curr.next != null);

        sb.append("NULL");

        return sb.toString();
    }

















    public static class Link<E>{
        private E data;
        public Link<E> next;

        public Link(){
        }
        public Link(E e){
            this.data = e;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }



}
