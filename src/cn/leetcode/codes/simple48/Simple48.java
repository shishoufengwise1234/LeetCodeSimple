package cn.leetcode.codes.simple48;

import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class Simple48 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/rotate-image/
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

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        Simple48 simple48 = new Simple48();

        simple48.rotate1(matrix);

        PKt.out(Arrays.deepToString(matrix));

    }


    /*
给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[7,4,1],[8,5,2],[9,6,3]]
示例 2：


输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
示例 3：

输入：matrix = [[1]]
输出：[[1]]
示例 4：

输入：matrix = [[1,2],[3,4]]
输出：[[3,1],[4,2]]
 

提示：

matrix.length == n
matrix[i].length == n
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
     */


    //辅助数组方式
    public void rotate1(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return;
        }
        int n = matrix.length;
        //采用辅助数组记录旋转之后的数值
        int[][] newMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(newMatrix[i], 0, matrix[i], 0, n);
        }

    }




}
