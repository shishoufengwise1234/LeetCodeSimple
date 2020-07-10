package cn.leetcode.codes.simple119;

import cn.leetcode.codes.PKt;

import java.util.ArrayList;
import java.util.List;

public class Simple119 {


    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/pascals-triangle-ii/
     * <p>
     * 1 刷是否通过：没有
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
     * 最优解析：https://leetcode-cn.com/problems/pascals-triangle-ii/solution/119yang-hui-san-jiao-ii-dong-tai-gui-hua-by-ceng-j/
     *
     */

    public static void main(String[] args) {

        List<Integer> list = new Simple119().getRow(3);

        PKt.out(list);

    }


    /*
    119. 杨辉三角 II
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]
进阶：

你可以优化你的算法到 O(k) 空间复杂度吗？
     */


    public List<Integer> getRow(int rowIndex) {
        List<Integer> rowList = new ArrayList<>(rowIndex + 1);
        //计算到 rowIndex + 1 项数据
        for (int i = 0; i <= rowIndex; i++) {
            //首位保持 1
            rowList.add(1);
            for (int j = i; j > 1 ; j--) {
                rowList.set(j - 1,rowList.get(j - 2) + rowList.get(j - 1));
            }
        }
        return rowList;
    }
}
