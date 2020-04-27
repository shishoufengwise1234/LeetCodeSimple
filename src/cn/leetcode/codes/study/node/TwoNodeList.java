package cn.leetcode.codes.study.node;

import cn.leetcode.codes.PKt;

/**
 * Created by shishoufeng on 2020/4/27.
 * <p>
 * desc : 双向链表 集合
 */
public class TwoNodeList<E> {

    //大小
    private transient int mSize = 0;

    // 前置节点
    private TwoNode<E> mHeadNode;
    // 总的节点数据
    private TwoNode<E> mTotalNode;

    public TwoNodeList(){
        this.mHeadNode = new TwoNode<>();
        this.mTotalNode = new TwoNode<>();

        this.mHeadNode.next = null;
        this.mTotalNode.next = null;
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
     * 添加 数据
     *
     * @param e 添加的数据对象
     */
    public void add(E e){
        TwoNode<E> currNode = this.mHeadNode;
        while (currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = new TwoNode<>(e);

        this.mSize++;
    }

    /**
     *
     * 在指定顺序后面添加节点
     *
     * @param pos 顺序
     * @param e 数据
     */
    public void addLast(int pos,E e){
        PKt.out("pos = "+pos+" e = "+e);

        TwoNode<E> curr = getNode(pos);

        // 先将当前指针 的后继指针的指针 指向当前指针的后继指针 避免链表断裂
        TwoNode<E> newNode = new TwoNode<>(e);
        newNode.next = curr.next.next;

        curr.next = newNode;

        this.mSize++;
    }

    /**
     *
     * 在指定位置 前面添加 指定节点数据
     *
     * @param pos 顺序
     * @param e  数据
     */
    public void addFirst(int pos,E e){
        PKt.out("addFirst() pos = "+pos + " e = "+e);

        TwoNode<E> curr = getNode(pos);

        // 先将后继指针 指向新的节点
        TwoNode<E> newNode = new TwoNode<>(e);
        newNode.next = curr.next;

        // 将当前节点 指向指定节点 的前驱指针
        curr.pre = newNode;

        this.mSize++;
    }

    /**
     *
     * 移除一个 数据
     *
     * @param e 移除的节点数据
     */
    public void remove(E e){

    }

    /**
     *
     * 获取指定节点数据
     *
     * @param pos 位置编号
     * @return 节点数据 or null
     */
    public TwoNode<E> getNode(int pos){
        PKt.out("getNode() pos = "+pos);

        // 如果获取 小于0 节点直接返回 头节点
        if (pos <= 0){
            return this.mHeadNode;
        }
        TwoNode<E> currNode = this.mHeadNode;
        int count = 0;
        while (currNode.next != null){
            if (count == pos){
                break;
            }
            count++;
            currNode = currNode.next;
        }
        PKt.out("getNode() currNode = "+currNode);

        return currNode;
    }

    /**
     *
     * 找到当前序号 的前置节点
     *
     * @param pos 序号
     * @return 找到前驱节点
     */
    public TwoNode<E> findPre(int pos){
        PKt.out("findPre() pos = "+pos);

        if (pos <= 0){
            return mHeadNode;
        }

        return null;
    }



    public void outString(){
        PKt.out(mHeadNode.toString());
    }



}
