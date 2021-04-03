package cn.leetcode.codes.other;

import cn.leetcode.codes.PKt;

public class HashMapTestDemo {

    public static void main(String[] args) {

//        testHash();

        PKt.out(2 ^ 3);
        PKt.out(2 & 1);

    }

    //测试hash函数
    private static void testHash() {
        String[] keys = {"A","B","A","C","D","ABC","BCD","a"};
        for (int i = 0; i < keys.length; i++) {
            int hash = hash(keys[i]);
            PKt.out("hash = "+hash);
        }
        PKt.out("A".hashCode());
        PKt.out(64578 ^ (64578 >>> 16));

    }


    //copy 自JDK8实现
    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}


