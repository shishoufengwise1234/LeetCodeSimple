package cn.leetcode.codes.simple118;

import cn.leetcode.codes.PKt;

import java.util.ArrayList;
import java.util.List;

public class Simple118 {


    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/pascals-triangle/
     * <p>
     * 1 刷是否通过： 没有（陷入递归的死海里了。。。。）
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
     * 最优解析：官方
     */


    public static void main(String[] args) {

        List<List<Integer>> lists = new Simple118().generate(6);

        PKt.out(lists);

    }

    /*
    118. 杨辉三角
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
     */

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> triangleList = new ArrayList<>(numRows);
        List<Integer> firstRowList = new ArrayList<>(1);
        firstRowList.add(1);
        triangleList.add(firstRowList);

        for (int row = 1; row <= numRows; row++) {
            List<Integer> rowList = new ArrayList<>();
            List<Integer> preRowList = triangleList.get(row - 1);

            //左侧列 均为 1
            rowList.add(1);

            for (int j = 1; j < row; j++) {
                rowList.add(preRowList.get(j - 1) + preRowList.get(j));
            }
            triangleList.add(rowList);

            //右侧列 均为 1
            rowList.add(1);
        }
        return triangleList;
    }

}
