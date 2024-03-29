package cn.leetcode.codes.simple45;

import cn.leetcode.codes.PKt;

public class Simple45 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/jump-game-ii/
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

        int[] nums = {2,3,1,1,4};
        int re = new Simple45().jump(nums);

        PKt.out("re = "+re);



    }

    /*
    给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
说明:

假设你总是可以到达数组的最后一个位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int jump(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int step = 0;
        int maxPosition = 0;
        int end = 0;

        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);

            //到达跳跃点重合
            if (i == end){
                //更新终点位置
                end = maxPosition;

                step++;
            }
        }

        return step;
    }
}
