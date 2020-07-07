package cn.leetcode.codes.simple58;

import cn.leetcode.codes.PKt;

import javax.accessibility.AccessibleEditableText;

public class Simple58 {


    /**
     * 刷题情况
     * <p>
     * 题目地址：
     * <p>
     * 1 刷是否通过：通过
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
     * 最优解析：https://leetcode-cn.com/problems/length-of-last-word/solution/hua-jie-suan-fa-58-zui-hou-yi-ge-dan-ci-de-chang-d/
     *
     */

    public static void main(String[] args) {

        String s = "Hello World ";

        int sum = new Simple58().lengthOfLastWord(s);
        //代码简洁
        int sum2 = new Simple58().lengthOfLastWord2(s);

        PKt.out(sum);
        PKt.out(sum2);

    }




    /*
    58. 最后一个单词的长度
给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

示例:

输入: "Hello World"
输出: 5
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        //先找出从后向前遍历的起始位置 过滤掉末尾的空格
        int beginFos = chars.length - 1;
        for (int i = chars.length - 1; i >= 0 ; i--) {
            char c = chars[i];
            if (c != ' '){
                beginFos = i;
                break;
            }
        }
        //计算最后一个单词的长度 遇到空格就停止
        int sum = 0;
        for (int j = beginFos; j >= 0; j--) {
            char c = chars[j];
            if (c == ' '){
                break;
            }else{
                sum++;
            }
        }
        return sum;
    }

    public int lengthOfLastWord2(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            //遇到空格停止
            if (c == ' '){
                //末尾单词有空格需要跳过
                if (count == 0){
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }
}



