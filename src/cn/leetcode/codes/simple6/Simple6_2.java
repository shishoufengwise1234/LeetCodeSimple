package cn.leetcode.codes.simple6;

import java.util.ArrayList;
import java.util.List;

public class Simple6_2 {

    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        List<StringBuilder> lists = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows,s.length()); i++) {
            lists.add(new StringBuilder());
        }

        char[] chars = s.toCharArray();

        int currRow = 0;
        boolean goingDown = false;

        for (char c : chars){
            StringBuilder sb = lists.get(currRow);
            sb.append(c);
            //到达第一行 或 最后一行 时需要变换方向
            if (currRow == 0 || currRow == numRows - 1){
                goingDown = !goingDown;
            }
            currRow += goingDown ? 1: -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder ch : lists){
            sb.append(ch);
        }
        return sb.toString();
    }
}
