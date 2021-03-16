package cn.leetcode.codes.other;

import cn.leetcode.codes.PKt;

public class TestClassCreated {

    static int s = 1;
//
//    static {
//        PKt.out("static 代码块" + s);
//    }

    {
        PKt.out("普通代码块" + s);
    }

    public TestClassCreated(){
        PKt.out("构造器" + s);
    }

    public void doSin(){
        PKt.out("doSin "+s);
    }


    public static void main(String[] args) {

//        TestClassCreated.s = 4;
//        new TestClassCreated().doSin();

        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);


        Integer i3 = 90;
        Integer i4 = 90;


        PKt.out(i1 == i2); //false
        PKt.out(i3 == i4); //false








    }
}
