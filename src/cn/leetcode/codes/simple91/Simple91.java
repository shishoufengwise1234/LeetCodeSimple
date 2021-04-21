package cn.leetcode.codes.simple91;

import cn.leetcode.codes.PKt;

public class Simple91 {


    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/decode-ways/
     *
     * 1 刷是否通过：no
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

        String s = "226";
        int re = new Simple91().numDecodings(s);

        PKt.out(re);

    }

    /*
    一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：

'A' -> 1
'B' -> 2
...
'Z' -> 26
要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：

"AAJF" ，将消息分组为 (1 1 10 6)
"KJF" ，将消息分组为 (11 10 6)
注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。

给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。

题目数据保证答案肯定是一个 32 位 的整数。

 

示例 1：

输入：s = "12"
输出：2
解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2：

输入：s = "226"
输出：3
解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
示例 3：

输入：s = "0"
输出：0
解释：没有字符映射到以 0 开头的数字。
含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
示例 4：

输入：s = "06"
输出：0
解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 

提示：

1 <= s.length <= 100
s 只包含数字，并且可能包含前导零。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */




    public int numDecodings(String s) {
        //前导零 说明无解
        if (s.charAt(0) == '0'){
            return 0;
        }
        char[] chars = s.toCharArray();

        int last2 = 1,last1 = 1;

        for (int i = 1; i < chars.length; i++) {
            int temp = last1;

            if (chars[i] == '0'){
                if (chars[i - 1] == '1' || chars[i - 1] == '2'){
                    temp = last2;
                }else{
                    return 0;
                }
            }else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] - '0' > 0 && chars[i] - '0' < 7)){
                temp += last2;
            }
            last2 = last1;
            last1 = temp;
        }
        return last1;
    }
}
