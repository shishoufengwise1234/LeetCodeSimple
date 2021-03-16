package cn.leetcode.codes.other;

import cn.leetcode.codes.PKt;

import java.util.concurrent.atomic.AtomicStampedReference;

public class TestVolatileDemo {

    //验证volatile 只能保证可见性

    private transient final Object object = new Object();

    volatile int start = 0;

    private void Keyword() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    //不使用synchronized 代码块 不能保证原子性
                    synchronized (TestVolatileDemo.class) {
                        start++;
                    }
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    public static void main(String[] args) {

//        TestVolatileDemo volatileDemo = new TestVolatileDemo();
//        volatileDemo.Keyword();
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        PKt.out(volatileDemo.start);

        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(3, 3);
        stampedReference.compareAndSet(3, 4, 4, 5);
    }
}
