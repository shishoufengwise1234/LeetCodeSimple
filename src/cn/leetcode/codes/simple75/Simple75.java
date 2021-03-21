package cn.leetcode.codes.simple75;

import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class Simple75 {

    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/sort-colors/
     * <p>
     * 1 刷是否通过：没有
     *
     *
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
     * <p>
     * 最优解析：
     */


    public static void main(String[] args) {

        int[] nums = {0,0,1,0,0,1,2, 0, 2, 1, 1, 0};
        Simple75 simple75 = new Simple75();
//        simple75.sortColors(nums);

        simple75.sortColors2(nums);

        PKt.out(Arrays.toString(nums));


    }

    /*
    给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。


示例 1：

输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
示例 2：

输入：nums = [2,0,1]
输出：[0,1,2]
示例 3：

输入：nums = [0]
输出：[0]
示例 4：

输入：nums = [1]
输出：[1]


提示：

n == nums.length
1 <= n <= 300
nums[i] 为 0、1 或 2


进阶：

你可以不使用代码库中的排序函数来解决这道题吗？
你能想出一个仅使用常数空间的一趟扫描算法吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-colors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public void sortColors2(int[] nums){
        if (nums.length <= 0){
            return;
        }
        int len = nums.length;
        int p0 = 0;
        int p1 = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;

                p1++;
            }else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;

                //如果连续0 后面才是1 需要将1向后挪动
                if (p0 < p1){
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }

                p0++;
                p1++;
            }
        }
    }




    //冒泡排序
    public void sortColors(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
