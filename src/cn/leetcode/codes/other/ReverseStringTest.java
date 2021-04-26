package cn.leetcode.codes.other;


import cn.leetcode.codes.PKt;

//字符串翻转
public class ReverseStringTest {



    public static void main(String[] args) {

        //String str = "Hello Word"; //Drow Olleh
        String str = " Hello Word wen is are H's "; // S'h Era Si New Drow Olleh

        ReverseStringTest test = new ReverseStringTest();

        String re = test.reverse1(str);

        PKt.out(str);
        PKt.out( re);

    }

    /*
    翻转字符串，但是单词首字母需要大写 如：Hello Word 翻转之后 : Drow Olleh

    2021.4.22 新美互通一面算法题
     */
    public String reverse1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = len - 1; i >= 0; i--) {
            char c = chars[i];

            //倒置第一个元素
            if (i == len - 1) {
                sb.append(Character.toUpperCase(c));
            } else if (i == 0) {
                sb.append(Character.toLowerCase(c));
            } else {
                //大写转小写
                if (Character.isUpperCase(c)) {
                    sb.append(Character.toLowerCase(c));
                } else {
                    //如果当前字符前面是空行，且当前字符是小写，需要转换成大写
                    if (Character.isLowerCase(c) && i + 1 < len && chars[i + 1] == ' ') {
                        sb.append(Character.toUpperCase(c));
                    } else {
                        sb.append(c);
                    }
                }
            }

        }
        return sb.toString();
    }
}
