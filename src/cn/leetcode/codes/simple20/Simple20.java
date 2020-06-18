package cn.leetcode.codes.simple20;

import cn.leetcode.codes.PKt;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Simple20 {

    public static void main(String[] args) {
        String s = "[]()";

        boolean re = new Simple20().isValid(s);

        PKt.out("re = "+re);
    }

    /*
    20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

     */

    public boolean isValid(String s) {
        if (s == null || s.length() <= 0){
            return true;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        char[] chars = s.toCharArray();
        Stack<Character> characters = new Stack<>();
        for (char c : chars){
            if (map.containsKey(c)){
                char topElement = characters.isEmpty() ? '#' : characters.pop();
                if (topElement != map.get(c)){
                    return false;
                }
            }else{
                characters.push(c);
            }
        }
        return characters.isEmpty();
    }


}
