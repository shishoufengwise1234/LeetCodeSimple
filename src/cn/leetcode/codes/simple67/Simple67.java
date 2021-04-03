package cn.leetcode.codes.simple67;

import cn.leetcode.codes.PKt;

public class Simple67 {

    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/add-binary/
     * <p>
     * 1 刷是否通过： 没有
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
     * 最优解析：https://leetcode-cn.com/problems/add-binary/solution/hua-jie-suan-fa-67-er-jin-zhi-qiu-he-by-guanpengch/
     */


    public static void main(String[] args) {

        String a = "11";
        String b = "1";

        Simple67 simple67 = new Simple67();
        String re = simple67.addBinary(a, b);
        String re2 = simple67.addBinary2(a, b);

        PKt.out("re = " + re + " , re2 = "+re2);

    }


    /*
    给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。

 

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"
 

提示：

每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-binary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //系统类库
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }


    //其他方案
    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int sum = 0;
        for (; i >= 0 || j >= 0; i--, j--) {
            int temp = sum;

            temp += i >= 0 ? a.charAt(i) - '0' : 0;
            temp += j >= 0 ? b.charAt(j) - '0' : 0;

            sb.append(temp % 2);
            sum = temp / 2;
        }
        sb.append(sum == 1 ? sum : "");

        return sb.reverse().toString();
    }
}
