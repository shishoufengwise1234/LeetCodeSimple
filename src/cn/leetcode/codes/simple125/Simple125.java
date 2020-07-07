package cn.leetcode.codes.simple125;

import cn.leetcode.codes.PKt;


public class Simple125 {

    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/valid-palindrome/
     * <p>
     * 1 刷是否通过：没有
     * 忘记对字符串进行过滤，先过滤出一个干净的字符串之后在使用双指针进行对比
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
     * 最优解析：https://leetcode-cn.com/problems/valid-palindrome/solution/yan-zheng-hui-wen-chuan-by-leetcode-solution/
     */

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        boolean isPalindrome = new Simple125().isPalindrome(s);

        PKt.out(isPalindrome);

    }

    /*
    125. 验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
     */

    //"A man, a plan, a canal: Panama"
    //"a man ap"

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        //过滤出数字和字母的字符串
        char[] chars = s.toCharArray();
        StringBuilder filterStr = new StringBuilder();
        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                filterStr.append(c);
            }
        }
        char[] filterChars = filterStr.toString().toCharArray();
        //使用双指针进行对比 并忽略大小写
        int low = 0,hgh = filterChars.length - 1;
        while (low <= hgh){
            if (Character.toUpperCase(filterChars[low]) != Character.toUpperCase(filterChars[hgh])){
                return false;
            }
            low++;
            hgh--;
        }
        return true;
    }
}
