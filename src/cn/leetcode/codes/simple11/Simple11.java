package cn.leetcode.codes.simple11;

import cn.leetcode.codes.PKt;

public class Simple11 {


    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/container-with-most-water/
     * <p>
     * 1 刷是否通过： 未通过
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
     * 最优解析：https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
     */

    public static void main(String[] args) {

//        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {1,1};
        int maxArea = new Simple11().maxArea(height);
        int maxArea2 = new Simple11_2().maxArea(height);

        PKt.out(maxArea);
        PKt.out(maxArea2);
    }

    /*
    11. 盛最多水的容器
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。





图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。



示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49
     */

    //使用双指针解法
    public int maxArea(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int p = 0,q = height.length - 1;
        int maxArea = 0;
        while (p < q){
            //求出当前指针区域面积大小
            int area = Math.min(height[p],height[q]) * (q - p);
            //比较出最大的面积
            maxArea = Math.max(area,maxArea);
            //移动指针，从较小的地方开始移动
            if (height[p] < height[q]){
                p++;
            }else{
                q--;
            }
        }
        return maxArea;
    }
}
