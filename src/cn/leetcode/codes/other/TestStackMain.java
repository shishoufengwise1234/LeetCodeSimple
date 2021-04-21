package cn.leetcode.codes.other;

import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class TestStackMain {

    public static void main(String[] args) {

        Stack stack = new Stack();
        for (int i = 0; i < 3; i++) {
            stack.push(i);
        }
        PKt.out(stack);


        for (int i = 0; i < 3; i++) {
            PKt.out(stack.pop());
        }

        PKt.out("pop after ...");
        PKt.out(stack);


        for (int i = 0; i < 19; i++) {
            stack.push(i);
        }

        PKt.out(stack);


        for (int i = 0; i < 9; i++) {
            PKt.out(stack.pop());
        }

        PKt.out(stack);




    }

    public static class Stack{

        private int[] mArrays = new int[8];
        private int mSize = 0;

        public void push(int val){
            if (mSize < mArrays.length){
                mArrays[mSize++] = val;
            }else{ //扩容
                int[] newArr = new int[this.mArrays.length << 1];
                System.arraycopy(this.mArrays, 0, newArr, 0, this.mArrays.length);

                newArr[this.mSize++] = val;
                this.mArrays = newArr;
            }
        }

        public int pop(){
            if (this.mSize - 1 < 0){
                return -1;
            }
            int val = mArrays[--this.mSize];
            mArrays[mSize] = -1;
            return val;
        }

        public int size(){
            return this.mSize;
        }

        @Override
        public String toString() {
            return "Stack{" +
                    "mArrays=" + Arrays.toString(mArrays) +
                    ", mSize=" + mSize +
                    '}';
        }
    }

}

