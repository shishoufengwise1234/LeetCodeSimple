package cn.leetcode.codes.simple28;

public class Simple28_2 {


    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0){
            return 0;
        }
        if (needle == null || needle.length() == 0){
            return 0;
        }
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();

        int hLen = haystack.length();
        int nLen = needle.length();

        for (int i = 0; i <= hLen - nLen; i++) {
            //从起始位置开始匹配
            int a = i,b = 0;

            while (b < nLen && h[a] == n[b]){
                a++;
                b++;
            }
            //完全匹配
            if (b == nLen){
                return i;
            }
        }
        return -1;
    }

}
