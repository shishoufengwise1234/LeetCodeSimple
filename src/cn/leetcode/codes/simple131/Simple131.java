package cn.leetcode.codes.simple131;

import cn.leetcode.codes.PKt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Simple131 {


    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/palindrome-partitioning/
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

        String s = "aabb";
        List<List<String>> lists = new Simple131().partition(s);

        PKt.out(lists);

    }


    /*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

回文串 是正着读和反着读都一样的字符串。

 

示例 1：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：

输入：s = "a"
输出：[["a"]]
 

提示：

1 <= s.length <= 16
s 仅由小写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-partitioning
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        if (s == null || s.length() == 0){
            return lists;
        }
        char[] chars = s.toCharArray();
        createPartition(lists,chars,0,s.length(),new ArrayDeque<>());
        return lists;
    }

    //生成回文子串
    private void createPartition(List<List<String>> lists, char[] chars, int start, int end, Deque<String> ans) {
        if (start == end) {
            lists.add(new ArrayList<>(ans));
            return;
        }
        for (int i = start; i < end; i++) {
            //不是回文串直接排除
            if (!isPartition(chars,start,i)){
                continue;
            }
            ans.addLast(new String(chars,start,i + 1 - start));
            createPartition(lists, chars, i + 1, end, ans);
            ans.removeLast();
        }
    }


    //判断是否是回文串
    private boolean isPartition(char[] chars,int low,int hgt) {
        if (chars == null) return false;
        if (chars.length == 1) return true;

        while (low <= hgt) {
            if (chars[low++] != chars[hgt--]) {
                return false;
            }
        }
        return true;
    }


}
