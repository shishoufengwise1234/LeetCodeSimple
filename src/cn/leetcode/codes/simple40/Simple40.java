package cn.leetcode.codes.simple40;

import cn.leetcode.codes.PKt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Simple40 {

    /**
     * 刷题情况
     * <p>
     * 题目地址：  https://leetcode-cn.com/problems/combination-sum-ii/
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
     * <p>
     * 最优解析：
     */

    public static void main(String[] args) {

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Simple40 simple40 = new Simple40();

        List<List<Integer>> ans = simple40.combinationSum2(candidates, target);
        PKt.out(ans);

    }

    /*
    40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
     */


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates.length == 0){
            return lists;
        }
        Arrays.sort(candidates);

        dfs(candidates, 0, candidates.length, target, lists,new ArrayDeque<>());
        return lists;
    }

    private void dfs(int[] candidates, int begin, int len, int target, List<List<Integer>> ans, ArrayDeque<Integer> deque){
        if (target == 0){
            ans.add(new ArrayList<>(deque));
            return;
        }
        for (int i = begin; i < len; i++) {
            //大剪枝
            if (target - candidates[i] < 0){
                break;
            }
            //当前数据和前一个数据相同 则跳过
            if (i > begin && candidates[i - 1] == candidates[i]){
                continue;
            }
            deque.addLast(candidates[i]);
            //不能使用重复的元素 所以 begin 需要向上走
            dfs(candidates, i + 1, len, target - candidates[i],ans,deque);
            deque.removeLast();
        }
    }







}
