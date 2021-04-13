package cn.leetcode.codes.simple3;

import java.util.HashMap;
import java.util.Map;

public class Simple3_5 {


    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        int ans = 0;

        //设立开始和结束位置
        for (int start = 0, end = 0; end < chars.length; end++) {
            char c = chars[end];
            if (map.containsKey(c)){
                start = Math.max(start,map.getOrDefault(c, 0));
            }
            map.put(c,end + 1);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
