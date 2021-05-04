package cn.leetcode.codes.simple28;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.simple217.Simple217;

public class Simple28 {


    public static void main(String[] args) {

        String haystack = "hello", needle = "ll";
//        String haystack = "a", needle = "a";
//        String haystack = "aaa", needle = "aaaa";

//        int strIndex = new Simple28().strStr(haystack,needle);
//        PKt.out(strIndex);


        int re = new Simple28_2().strStr(haystack, needle);

        PKt.out(re);



    }

    /*
       28. 实现 strStr()
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     */

    // 题解答案:
    // https://leetcode-cn.com/problems/implement-strstr/solution/hua-jie-leetcode28-shi-xian-strstr-by-deppwang-2/
    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0){
            return 0;
        }
        if (needle == null || needle.length() == 0){
            return 0;
        }
        char[] hayChars = haystack.toCharArray();
        char[] needChars = needle.toCharArray();

        int hLen = hayChars.length;
        int nLen = needChars.length;

        for (int i = 0; i <= hLen - nLen; i++) { //(hLen - nLen) 找出两个字符串近似相等的大小 进行遍历
            int k = 0;
            for (; k < nLen; k++) {
                // 依次比较两个字符串中 字符是否相同、不相同直接退出
                if (hayChars[i + k] != needChars[k]) {
                    break;
                }
            }
            //如果长度 和 needle 字符串相同则认为 符合条件
            if (k == nLen) {
                return i;
            }
        }
        return -1;
    }

}
