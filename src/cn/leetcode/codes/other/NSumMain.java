package cn.leetcode.codes.other;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.sort.SortKt;
import kotlin.UShortKt;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.MissingFormatArgumentException;

/*

nsum 问题

https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/nsum


 */
public class NSumMain {


    public static void main(String[] args) {

        int[] nums = {-1,0,2,3,5,6,9,23,45,7,4,8,56,2};
        int[] nums2 = {1,1,1,2,2,3,3};

        //获取两数之和 数据
        int[] re = getSumTarget(nums,8);

        PKt.out(Arrays.toString(re));

        List<List<Integer>> counts = getListSumTarget(nums2,4);

        PKt.out("counts = "+counts);


    }


    /**
     *
     * 获取集合中 多个数据和 为指定值的集合
     */
    public static List<List<Integer>> getListSumTarget(int[] nums,int target){

        //排序
        for (int i = 0; i < nums.length; i++) {
            boolean isQuit = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]){
                    SortKt.swap(nums, j,j + 1 );
                    isQuit = true;
                }
            }
            if (!isQuit){
                break;
            }
        }
        PKt.out("排序后数据 "+Arrays.toString(nums));

        int pro = 0;
        int next = nums.length - 1;
        List<List<Integer>> counts = new ArrayList<>();

        while (pro < next){
            int count = nums[pro] + nums[next];
            int left = nums[pro],right = nums[next];

            if (count == target){
                List<Integer> childList = new ArrayList<>();
                childList.add(left);
                childList.add(right);

                counts.add(childList);

                //去重 跳过重复的元素 下标
                while (pro < next && nums[pro] == left){
                    pro++;
                }
                while (pro < next && nums[next] == right){
                    next--;
                }
            }else if (count > target){
                while (pro < next && nums[next] == right){
                    next--;
                }
            }else{
                while (pro < next && nums[pro] == left){
                    pro++;
                }
            }
        }
        return counts;
    }


    /**
     *
     * 在数组中找到 两个数据 和 等于指定数据的 数组
     *
     */
    public static int[] getSumTarget(int[] nums,int target){
        //step 1：对数据进行先排序
//        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            boolean isQuit = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]){
                    SortKt.swap(nums,j, j + 1);
                    isQuit = true;
                }
            }
            //没有交换 直接提前退出循环
            if (!isQuit){
                break;
            }
        }

        PKt.out("排序后数据: "+Arrays.toString(nums));

        //step 2:使用双指针法进行找到和为指定数据的数据
        int pro = 0;
        int next = nums.length - 1;
        while (pro < next){
            int middle = nums[pro] + nums[next];
            if (middle == target){
                return new int[]{nums[pro],nums[next]};
            }else if (middle > target){
                next--;
            }else {
                pro++;
            }
        }
        return new int[]{0,0};
    }
}
