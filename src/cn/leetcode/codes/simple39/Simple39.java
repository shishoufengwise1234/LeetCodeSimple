package cn.leetcode.codes.simple39;

import cn.leetcode.codes.PKt;

import java.util.*;

public class Simple39 {




    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/combination-sum/
     *
     * 1 刷是否通过： 没有
     *
     * 回溯算法 + 剪枝
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
     */

    public static void main(String[] args) {

        //candidates = [2,3,6,7], target = 7,
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> re = new Simple39().combinationSum(candidates, target);
        PKt.out(re);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (candidates.length == 0) return ans;

        //首先进行排序
        Arrays.sort(candidates);

        int len = candidates.length;
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(candidates, 0, len, target, deque,ans);

        return ans;
    }

    //回溯算法
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> ans) {
        //使用target 减去数组中值 最终为0时 说明和target 值是相同的
        if (target <= 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            //数组有序 减去当前值已经小于0 没必要再循环下去
            if (target - candidates[i] < 0){
                break;
            }
            path.addLast(candidates[i]);
            //使用target减去数组中差值 并计算和递归链是否相同
            dfs(candidates, i, len, target - candidates[i],path,ans);
            path.removeLast();
        }
    }
}
