package cn.leetcode.codes.simple62;

import cn.leetcode.codes.ArrKt;
import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class Simple62 {


    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/unique-paths/
     * <p>
     * 1 刷是否通过：  没有
     * <p>
     * <p>
     * 2 刷是否完成：yes
     * <p>
     * <p>
     * 3 刷是否完成：yes
     * <p>
     * <p>
     * 4 刷是否完成：
     * <p>
     * <p>
     * 5 刷是否完成：
     *
     * 最优解析：https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-by-powcai-2/
     *
     * https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-by-powcai-2/
     */

    public static void main(String[] args) {

        int m = 3,n = 2;
        int count = new Simple62().uniquePaths(m,n);
        Simple62_2 simple62_2 = new Simple62_2();
        int count2 = simple62_2.uniquePaths(m,n);
        int count3 = simple62_2.uniquePaths2(m,n);

        Simple62_3 simple62_3 = new Simple62_3();
        int count4 = simple62_3.uniquePaths(m,n);
        int count5 = simple62_3.uniquePaths2(m,n);

        PKt.out("count = "+count);
        PKt.out("count2 = "+count2);
        PKt.out("count3 = "+count3);
        PKt.out("count4 = "+count4);
        PKt.out("count5 = "+count5);

    }

    /*
    62. 不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？



例如，上图是一个7 x 3 的网格。有多少可能的路径？



示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28


提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 10 ^ 9
     */

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0){
            return -1;
        }
        int[][] dp = new int[m][n];
        //将所有列全部赋值为 1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //将所有行全部赋值为 1
        for (int k = 0; k < m; k++) {
            dp[k][0] = 1;
        }
//        PKt.out(ArrKt.toString(dp));
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
//        PKt.out("处理之后 ： "+ArrKt.toString(dp));
        return dp[m - 1][n -1];
    }

}
