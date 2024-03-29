package cn.leetcode.codes.simple43;

import cn.leetcode.codes.PKt;

public class Simple43 {

    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/multiply-strings/
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
     * 最优解析：https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
     */

    public static void main(String[] args) {

        String num1 = "123";
        String num2 = "456";

        String re = new Simple43().multiply(num1, num2);

        PKt.out("re = " + re);

    }
    /*
    给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/multiply-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length(), n = num2.length();

        int[] ans = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';

            for (int j = n - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';

                int sum = (ans[i + j + 1] + n1 * n2);
                ans[i + j + 1] = sum % 10;
                ans[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if (i == 0 && ans[i] == 0) {
                continue;
            }
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}
