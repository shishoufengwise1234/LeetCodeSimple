package cn.leetcode.codes.simple3;

import java.util.HashMap;
import java.util.Map;

public class Simple3_4 {


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (i < chars.length) {
            char c = chars[i];
            if (map.containsKey(c)) {
                left = Math.max(left, map.getOrDefault(c, 0) + 1);
            }
            map.put(c, i);
            ans = Math.max(ans, i - left + 1);
            i++;
        }
        return ans;
    }
}