package cn.leetcode.codes.other;

// 基于数组实现的栈
public class ArrayTask<E> {

    private int mSize = 0;
    private Object[] objList = new Object[10];

    public ArrayTask() {
    }

    public void put(E e){
        if (mSize == objList.length){
            Object[] objects = new Object[objList.length * 2];
            System.arraycopy(objList, 0, objects, 0, objList.length);
        }else {
//            eList[mSize - 1] = e;
        }
        mSize++;
    }


}
