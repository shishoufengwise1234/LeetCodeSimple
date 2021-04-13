package cn.leetcode.codes.simple63;

import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class Simple63 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/unique-paths-ii/
     *
     * 1 刷是否通过：
     *
     *
     * 2 刷是否完成：yes
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
     *
     * 面试是否遇到过？
     *
     *
     * 企业：
     *
     *
     *
     *
     */

    public static void main(String[] args) {

        int[][] nums = {{0,0,0},{0,1,0},{0,0,0}};
//        int[][] nums = {{0,1},{0,0}};

        int re = new Simple63().uniquePathsWithObstacles(nums);
        int re2 = new Simple63_2().uniquePathsWithObstacles(nums);

        PKt.out(re);
        PKt.out(re2);


    }

    /*
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？



网格中的障碍物和空位置分别用 1 和 0 来表示。

 

示例 1：


输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
输出：2
解释：
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
示例 2：


输入：obstacleGrid = [[0,1],[0,0]]
输出：1
 

提示：

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] 为 0 或 1


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0){
            return -1;
        }
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];

        //处理第一个位置是 障碍物的情况
        dp[0] = obstacleGrid[0][0] == 0 ? 1: 0;

        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                //遇到障碍物跳过
                if (ints[j] == 1) {
                    //当前道路通畅
                    dp[j] = 0;
                    continue;
                }
                //保证路径可达
                if (j >= 1 && ints[j - 1] == 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n -1];
    }
}
