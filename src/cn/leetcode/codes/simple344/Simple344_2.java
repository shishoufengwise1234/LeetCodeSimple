package cn.leetcode.codes.simple344;

public class Simple344_2 {



    public void reverseString(char[] s) {
        if (s == null || s.length == 0){
            return;
        }
        int p = 0,q = s.length - 1;
        while (p <= q){
            char temp = s[p];
            s[p] = s[q];
            s[q] = temp;

            p++;
            q--;
        }
    }

}
