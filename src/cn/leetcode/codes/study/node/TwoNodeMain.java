package cn.leetcode.codes.study.node;

public class TwoNodeMain {


    public static void main(String[] args){


        TwoNodeList<String> nodeList = new TwoNodeList<>();

        for (int i = 0; i < 14; i++) {
            nodeList.add(i+"");
        }

        nodeList.outString();

    }


}

