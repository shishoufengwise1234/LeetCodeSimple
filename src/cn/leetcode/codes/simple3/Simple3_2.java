package cn.leetcode.codes.simple3;

import cn.leetcode.codes.PKt;

import java.util.HashMap;

public class Simple3_2 {

    public static void main(String[] args) {
        String s = "abcb";
        int re = new Simple3_2().lengthOfLongestSubstring(s);
        PKt.out("re = "+re);
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() <= 0){
            return 0;
        }
        //左指针
        int left = 0;
        //最大长度
        int max = 0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            //判断窗口中是否已经出现过此字符
            if (hashMap.containsKey(c)){
                left = Math.max(left,hashMap.get(c) + 1);
            }
            hashMap.put(c,i);
            //计算滑动窗口距离
            max = Math.max(max,i - left + 1);
        }
        return max;
    }
}
