package cn.leetcode.codes.simple55;

import cn.leetcode.codes.PKt;
import sun.tools.jconsole.MaximizableInternalFrame;

public class Simple55 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/jump-game/
     *
     * 1 刷是否通过：没有
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
     * 最优解析：https://leetcode-cn.com/problems/jump-game/solution/55-by-ikaruga/
     *
     */

    public static void main(String[] args) {

//        int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
        boolean re = new Simple55().canJump(nums);

        PKt.out("re = "+re);



    }

    /*
    给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标。

 

示例 1：

输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
示例 2：

输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 

提示：

1 <= nums.length <= 3 * 104
0 <= nums[i] <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean canJump(int[] nums) {
        if (nums.length == 0){
            return true;
        }
        int n = nums.length;
        int can = 0;

        for (int i = 0; i < n; i++) {
            int v = nums[i];
            //枚举步数 已经超过 记录步数
            if (i > can){
                return false;
            }
            can = Math.max(can, v + i);
        }
        return true;
    }
}
