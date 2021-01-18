package cn.leetcode.codes.simple15;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.sort.SortKt;

import java.util.ArrayList;
import java.util.List;

public class Simple15 {


    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

//        List<List<Integer>> list1 = new Simple15().threeSum(nums);
        List<List<Integer>> list2 = new Simple15_2().threeSum(nums);

//        PKt.out(list1);
        PKt.out(list2);


    }

    /*
    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        //排序
        for (int i = 0; i < nums.length; i++) {
            boolean isQuit = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]){
                    SortKt.swap(nums,j,j+1);
                    isQuit = true;
                }
            }
            if (!isQuit){
                break;
            }
        }
        int pro = 0;
        int next = nums.length -1;
        List<List<Integer>> counts = new ArrayList<>();

        while (pro < next){

        }


        return null;
    }
}
