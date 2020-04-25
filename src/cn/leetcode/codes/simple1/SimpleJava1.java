package cn.leetcode.codes.simple1;

import java.util.Arrays;

public class SimpleJava1 {


    
    public static void main(String[] args){
    
        int[] intArr = {2,34,4,45,6,9,3};

        int[] re = printIndex(intArr,37);

        System.out.println(" re = "+ Arrays.toString(re));
        
    }




    private static int[] printIndex(int[] nums, int target) {
        int[] re = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                System.out.println("1 下标: i = "+i+" j = "+j);

                if (nums[i] + nums[j] == target){
                    re[0] = i;
                    re[1] = j;
                    System.out.println("下标: i = "+i+" j = "+j);
                    System.out.println("数据: i = "+nums[i]+" j = "+nums[j]);
                }
            }
        }
        return re;
    }


}
