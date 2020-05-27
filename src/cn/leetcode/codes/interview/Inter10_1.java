package cn.leetcode.codes.interview;

import cn.leetcode.codes.PKt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inter10_1 {


    public static void main(String[] args) {

        Inter10_1 inter10_1 = new Inter10_1();

//        PKt.out("fib 0 = " + inter10_1.fib(0));
//        PKt.out("fib 1 = " + inter10_1.fib(1));
//        PKt.out("fib 2 = " + inter10_1.fib(2));
//        PKt.out("fib 3 = " + inter10_1.fib(3));
//        PKt.out("fib 5 = " + inter10_1.fib(5));
//        PKt.out("fib 10 = " + inter10_1.fib(10));
//        PKt.out("fib 44 = " + inter10_1.fib(44));
        PKt.out("fib 45 = " + inter10_1.fib(45));

//        PKt.out("fib2 0 = " + inter10_1.fib2(0));
//        PKt.out("fib2 1 = " + inter10_1.fib2(1));
//        PKt.out("fib2 2 = " + inter10_1.fib2(2));
//        PKt.out("fib2 3 = " + inter10_1.fib2(3));
//        PKt.out("fib2 5 = " + inter10_1.fib2(5));
//        PKt.out("fib2 10 = " + inter10_1.fib2(10));
//        PKt.out("fib2 44 = " + inter10_1.fib2(44));
//        PKt.out("fib2 45 = " + inter10_1.fib2(45));


    }

    /*
    写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 

示例 1：

输入：n = 2
输出：1
示例 2：

输入：n = 5
输出：5
 

提示：

0 <= n <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public int fib(int n){


        return 0;
    }


//    public int fib(int n) {
//        if (n <= 0) {
//            return 0;
//        }
//        if (n <= 1) {
//            return 1;
//        }
//        return fib(n - 1) + fib(n - 2);
//    }

//    public int fib2(int n) {
//        if (n <= 0) {
//            return 0;
//        }else if (n <= 1) {
//            return 1;
//        }else {
//            List<Integer> arr = new ArrayList<>(n);
//            for (int i = 0; i <= n; i++) {
//                if (i == 0) {
//                    arr.add(0);
//                } else if (i == 1) {
//                    arr.add(1);
//                } else {
//                    arr.add(arr.get(i - 1) + arr.get(i - 2));
//                }
//            }
//            PKt.out("arr = " + arr);
//
//            return arr.get(arr.size() - 1);
//        }
//    }
}
