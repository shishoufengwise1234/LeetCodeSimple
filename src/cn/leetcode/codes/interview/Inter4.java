package cn.leetcode.codes.interview;

import cn.leetcode.codes.ArrKt;
import cn.leetcode.codes.PKt;

import java.util.Arrays;
import java.util.Objects;

public class Inter4 {

    /*

面试题04. 二维数组中的查找
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。


示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。



限制：

0 <= n <= 1000

0 <= m <= 1000



注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
     */

    public static void main(String[] args) {

        int[][] array = {{2, 1, 4, 5, 9}, {0, 4, 0, 3}};

        PKt.out("array = " + ArrKt.toString(array));

        boolean isRe = new Inter4().findNumberIn2DArray(array,-1);

        PKt.out("isRe = "+isRe);

    }


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] sub : matrix) {
            for (int i : sub) {
                if (i == target) {
                    return true;
                }
            }
        }
        return false;
    }

}
