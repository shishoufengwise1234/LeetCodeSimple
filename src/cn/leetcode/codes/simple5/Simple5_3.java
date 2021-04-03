package cn.leetcode.codes.simple5;

public class Simple5_3 {


    //动态规划
    public String longestPalindrome(String s) {
        int len = s.length();
        //对特殊字符进行提前判断
        if (len < 2) {
            return s;
        }
        String ans = "";
        boolean[][] dp = new boolean[len][len];
        //枚举
        for (int l = 0; l < len; l++) {
            for (int i = 0; i + l < len; i++) {
                int j = i + l;
                //第一行数据
                if (l == 0) {
                    dp[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (l == 1) {
                        dp[i][j] = b;
                    } else {
                        dp[i][j] = (b && dp[i + 1][j - 1]);
                    }
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

}
