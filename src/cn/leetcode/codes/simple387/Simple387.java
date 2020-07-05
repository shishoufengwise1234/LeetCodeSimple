package cn.leetcode.codes.simple387;

import cn.leetcode.codes.PKt;

import java.util.HashMap;
import java.util.HashSet;

public class Simple387 {

    public static void main(String[] args) {

//        String s = "leetcode";
        String s = "loveleetcode";

        int firstUniqCharIndex = new Simple387().firstUniqChar(s);
        PKt.out(firstUniqCharIndex);


    }

    /*
387. 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。


示例：

s = "leetcode"
返回 0

s = "loveleetcode"
返回 2


提示：你可以假定该字符串只包含小写字母。
     */


    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0){
            return -1;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        HashMap<Character,Integer> containMap = new HashMap<>();

        for (char c : chars) {
            containMap.put(c, containMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            if (containMap.get(c) == 1){
                return i;
            }
        }
        return -1;
    }

}
