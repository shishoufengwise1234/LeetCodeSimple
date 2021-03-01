package cn.leetcode.codes.simple703;

import cn.leetcode.codes.PKt;

import java.util.PriorityQueue;

public class Simple703 {

    public static void main(String[] args) {

        int[] nums = {4, 5, 8, 2};
        KthLargest largest = new KthLargest(3, nums);
        PKt.out(largest.add(3));   // return 4
        PKt.out(largest.add(5));   // return 5
        PKt.out(largest.add(10));  // return 5
        PKt.out(largest.add(9));   // return 8
        PKt.out(largest.add(4));   // return 8

    }


}

class KthLargest {

    private int mKey;
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        mKey = k;
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > mKey) {
            queue.poll();
        }
        return queue.peek();
    }
}
