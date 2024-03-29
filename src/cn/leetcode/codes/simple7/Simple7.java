package cn.leetcode.codes.simple7;

public class Simple7 {


    public static void main(String[] args) {


        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(130));

        System.out.println(" JDK ---");

//        System.out.println(Integer.reverse(123));
//        System.out.println(Integer.reverse(-123));
//        System.out.println(Integer.reverse(130));

    }


    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            // 取出个位数数据
            int pop = x % 10;

            //不断地取出个位数
            x /= 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)){
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /*
    作者：LeetCode
    链接：https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    */
}
