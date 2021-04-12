package cn.leetcode.codes.simple77;

import cn.leetcode.codes.PKt;

import java.util.ArrayList;
import java.util.List;

public class Simple77 {

    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/combinations/
     * <p>
     * 1 刷是否通过：
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
     * <p>
     * 最优解析：https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
     * <p>
     * <p>
     * 面试是否遇到过？
     * <p>
     * <p>
     * 企业：
     */

    public static void main(String[] args) {

        int n = 4, k = 2;

        Simple77 simple77 = new Simple77();
        List<List<Integer>> lists = simple77.combine(n, k);

        PKt.out(lists);

    }

    /*
    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //回溯算法
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 0 && k <= 0) {
            return ans;
        }
        createCombine(1, n, k, ans, new ArrayList<Integer>());
        return ans;
    }

    private void createCombine(int start, int n, int k, List<List<Integer>> ans, ArrayList<Integer> integers) {
        //达到指定个数
        if (integers.size() == k) {
            ans.add(new ArrayList<>(integers));
            return;
        }
        for (int i = start; i <= n; i++) {
            integers.add(i);
            createCombine(i + 1, n, k, ans, integers);
            integers.remove(integers.size() - 1);
        }
    }


}
