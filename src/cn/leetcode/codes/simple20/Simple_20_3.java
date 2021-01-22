package cn.leetcode.codes.simple20;

import cn.leetcode.codes.PKt;

import java.util.HashMap;

public class Simple_20_3 {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('{', '}');
        hashMap.put('[', ']');

        int l = 1;
        for (int i = 0; i < s.length(); i++) {

        }





//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (hashMap.containsKey(c)) {
//                char right = hashMap.getOrDefault(c, ' ');
//                PKt.out("right = " + right);
//
//                boolean isVaTemp = false;
//                for (int j = i + 1; j < s.length(); j++) {
//                    if (s.charAt(j) == right) {
//                        isVaTemp = true;
//                        break;
//                    }
//                }
//                if (!isVaTemp) {
//                    return false;
//                }
//            }
//        }
        return true;
    }
}
