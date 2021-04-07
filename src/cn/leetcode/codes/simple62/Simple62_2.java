package cn.leetcode.codes.simple62;

import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class Simple62_2 {


    //动态规划
    //动态方程
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0){
            return -1;
        }
        int[][] dp = new int[m][n];

        //填充数据
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        PKt.out(Arrays.deepToString(dp));

        return dp[m - 1][n - 1];
    }

    //优化空间复杂度
    public int uniquePaths2(int m,int n){
        if (m <= 0 || n <= 0){
            return -1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n -1];
    }


}
