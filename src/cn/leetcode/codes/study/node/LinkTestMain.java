package cn.leetcode.codes.study.node;

import cn.leetcode.codes.PKt;

public class LinkTestMain {

    public static void main(String[] args){

        Linked<String> stringLinked = new Linked<>();

        stringLinked.addFirst("First");

        PKt.out(stringLinked.outString());

        for (int i = 1; i < 5; i++) {
            stringLinked.addLast(""+i);
        }
        PKt.out(stringLinked.outString());

        stringLinked.addFirst("First 2");

        PKt.out(stringLinked.outString());

        stringLinked.add(3,"add Index 3");

        PKt.out(stringLinked.outString());

        // 检测是否存在
        for (int i = 0; i < 3; i++) {
            boolean isContains = stringLinked.contains("3");
            PKt.out(i+" is contains "+isContains);
        }





    }
}
