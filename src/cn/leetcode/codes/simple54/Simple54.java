package cn.leetcode.codes.simple54;

import cn.leetcode.codes.PKt;

import java.util.ArrayList;
import java.util.List;

public class Simple54 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/spiral-matrix/
     *
     * 1 刷是否通过： no
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
     * 最优解析：https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-leetcode-solution/
     *
     * 评论
     *
     *
     * 面试是否遇到过？
     *
     *
     * 企业：字节跳动
     *
     *
     *
     *
     */


    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Simple54 simple54 = new Simple54();
        List<Integer> list = simple54.spiralOrder(matrix);

        PKt.out(list);

    }


    /*
    给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

 

示例 1：


输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：


输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 

提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //旋转打印
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0){
            return ans;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int total = n * m;

        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;

        while (total >= 1){
            for (int i = left; i <= right && total >= 1; i++) {
                ans.add(matrix[top][i]);
                total--;
            }
            top++;
            for (int i = top; i <= bottom && total >= 1 ; i++) {
                ans.add(matrix[i][right]);
                total--;
            }
            right--;
            for (int i = right; i >= left && total >= 1; i--) {
                ans.add(matrix[bottom][i]);
                total--;
            }
            bottom--;
            for (int i = bottom; i >= top && total >= 1 ; i--) {
                ans.add(matrix[i][left]);
                total--;
            }
            left++;
        }
        return ans;
    }
}
