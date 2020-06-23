package cn.leetcode.codes.other;

import cn.leetcode.codes.PKt;


//二分查找算法代码示例
public class HalfSearchMain {

    public static void main(String[] args) {
        HalfSearchMain halfSearchMain = new HalfSearchMain();

        int[] nums = {1,3,4,6,6,7,8,8,8,9,10};

        int index;
//        index = halfSearchMain.halfSearch(nums,8);
//        index = halfSearchMain.halfSearchFirstTarget(nums,8);
//        index = halfSearchMain.halfSearchLastTarget(nums,8);
//        index = halfSearchMain.halfSearchFirstOutTarget(nums,5);
        index = halfSearchMain.halfSearchLastLowTarget(nums,5);


        PKt.out("index = "+index);
    }

    //查找最后一个小于等于给定值的位置
    public int halfSearchLastLowTarget(int[] nums,int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target){
                if (mid == nums.length - 1 || nums[mid + 1] > target){
                    return mid;
                }else{
                    left = mid + 1;
                }
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    //查找第一个大于等于给定值的数据位置
    public int halfSearchFirstOutTarget(int[] nums,int target){
        if (nums == null || nums.length <= 0){
            return -1;
        }
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target){
                if (mid == 0 || nums[mid - 1] < target){
                    return mid;
                }else{
                    right = mid - 1;
                }
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }

    //查找最后给定值的元素位置
    public int halfSearchLastTarget(int[] nums,int target){
        if (nums == null || nums.length <= 0){
            return -1;
        }
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else{
                if (mid == nums.length - 1 || nums[mid + 1] != target){
                    return mid;
                }else{
                    //继续往后查找
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    //查找给定值的第一次出现位置
    public int halfSearchFirstTarget(int[] nums,int target){
        if (nums == null || nums.length <= 0){
            return -1;
        }
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] > target){
                right = mid -1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else{
                //mid 值等于要查找的值时 进行确定
                if (mid == 0 || nums[mid - 1] != target){
                    return mid;
                }else{
                    //说明要查找的值 在前面需要往前进行查找
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    //查找给定值数据的二分查找
    public int halfSearch(int[] nums,int target){
        if (nums == null || nums.length <= 0){
            return 0;
        }
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = left+(right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return 0;
    }
}
