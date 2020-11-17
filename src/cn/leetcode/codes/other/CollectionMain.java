package cn.leetcode.codes.other;

import cn.leetcode.codes.PKt;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionMain {

    public static void main(String[] args) {

//        testCollectionSet();

        testDeque();
    }

    private static void testDeque() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            arrayDeque.add(i);
        }
        arrayDeque.addFirst(-1);
        arrayDeque.addLast(100);

        PKt.out(arrayDeque);

        //倒序输出
        Iterator<Integer> iterator = arrayDeque.descendingIterator();
        while (iterator.hasNext()){
            PKt.out(iterator.next());
        }


    }

    private static void testCollectionSet() {

        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            stringSet.add(i+"");
        }

        for (String str : stringSet){
            PKt.out(str);
        }
        PKt.out("--------iterable---------");

        Iterator<String> it = stringSet.iterator();
        while (it.hasNext()){
            PKt.out(it.next());
        }

    }


}
