package cn.leetcode.codes.simple64;

import cn.leetcode.codes.PKt;

public class Simple64 {

    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/minimum-path-sum/
     * <p>
     * 1 刷是否通过：
     * <p>
     * <p>
     * 2 刷是否完成：no
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
     * 最优解析：https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
     * <p>
     * <p>
     * 面试是否遇到过？
     * <p>
     * <p>
     * 企业：
     */

    public static void main(String[] args) {

        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        int re = new Simple64().minPathSum(nums);
        int re2 = new Simple64_2().minPathSum(nums);

//        PKt.out("re = " + re);
        PKt.out("re2 = " + re2);

    }
    /*
    给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

 

示例 1：


输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。
示例 2：

输入：grid = [[1,2,3],[4,5,6]]
输出：12

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0){
                    continue;
                }
                if (i == 0){
                    grid[i][j] += grid[i][j - 1];
                }else if (j == 0){
                    grid[i][j] += grid[i -1][j];
                }else{
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }

}
