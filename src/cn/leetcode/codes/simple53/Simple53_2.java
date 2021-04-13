package cn.leetcode.codes.simple53;

public class Simple53_2 {


    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        //总和 必须是第一个元素 防止数组数据是一个的情况下
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            //sum 如果是大于0 则对整体结果向上 否则就会无效
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            //不断的求出最大值并缓存下来
            ans = Math.max(sum, ans);
        }
        return ans;
    }

}
