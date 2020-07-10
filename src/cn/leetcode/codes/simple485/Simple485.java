package cn.leetcode.codes.simple485;


import cn.leetcode.codes.PKt;

public class Simple485 {


    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/max-consecutive-ones/
     * <p>
     * 1 刷是否通过：通过 自己算法和官方一致
     * <p>
     * <p>
     * 2 刷是否完成：
     * <p>
     * <p>
     * 3 刷是否完成：
     * <p>
     * <p>
     * 4 刷是否完成：
     * <p>
     * <p>
     * 5 刷是否完成：
     *
     * 最优解析：官方
     */
    public static void main(String[] args) {

        int[] ints = {1,1,0,1,1,1,0,0,1,1,1,1,1};
        int max = new Simple485().findMaxConsecutiveOnes(ints);

        PKt.out(max);


    }

    /*
给定一个二进制数组， 计算其中最大连续1的个数。

示例 1:

输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
注意：

输入的数组只包含 0 和1。
输入数组的长度是正整数，且不超过 10,000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-consecutive-ones
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        //缓存最大值
        int max = 0;
        //每次记录 1 出现的次数
        int ans = 0;
        for (int n : nums){
            if (n == 0){
                ans = 0;
            }else {
                ans++;
            }
            //求出最大值
            max = Math.max(max,ans);
        }
        return max;
    }

}
