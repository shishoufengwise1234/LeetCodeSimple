package cn.leetcode.codes.other;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ComponentMain {


    public static void main(String[] args) {

        String[] names = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
        String[] names2 = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};

        List<String> list = printComponent(names, names2,100);
        PKt.out(list.size());
        PKt.out(list);
    }

    private static List<String> printComponent(String[] names, String[] names2, int target) {
        List<String> list = new ArrayList<>();
        int count = 0;
        int i = 0;
        int j = 0;
        while (count < target) {
            if (i == names.length) {
                i = 0;
            }
            if (j == names2.length) {
                j = 0;
            }
            String name = names[i] + names2[j];
            list.add(name);

            i++;
            j++;
            count++;
        }
        return list;
    }



}
