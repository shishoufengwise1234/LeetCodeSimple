package cn.leetcode.codes.other;

import cn.leetcode.codes.PKt;
import sun.awt.datatransfer.DataTransferer;

import java.util.Arrays;

public class OtherMain {


    public static void main(String[] args){


        OtherMain main = new OtherMain();

        int[] ins = {-1,0,5,2,8,0,0,0,5,-1,98,0,0,56};
        int[] reIns = main.sufferList(ins);

        PKt.out(Arrays.toString(reIns));


    }



    /*

    要求 [5,2,8,0,0,0,5]
    输出：[5,2,8,5,0,0,0]

    非零数据位置不动
     */
    public int[] sufferList(int[] ints){
//        int[] newInts = new int[ints.length];
        int pos = 0;
//        for (int anInt : ints) {
//            if (anInt != 0) {
//                newInts[pos] = anInt;
//                pos++;
//            }
//        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0){
                int temp = ints[i];
                ints[i] = ints[pos];
                ints[pos] = temp;
                pos++;
            }
        }
//        return newInts;
        return ints;
    }
}
