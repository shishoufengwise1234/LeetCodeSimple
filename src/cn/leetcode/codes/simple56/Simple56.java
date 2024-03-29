package cn.leetcode.codes.simple56;

import cn.leetcode.codes.PKt;
import kotlin.collections.ArraysKt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Simple56 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/merge-intervals/
     *
     * 1 刷是否通过：
     *
     *
     * 2 刷是否完成：
     *
     *
     * 3 刷是否完成：
     *
     *
     * 4 刷是否完成：
     *
     *
     * 5 刷是否完成：
     *
     * 最优解析：
     *
     */

    public static void main(String[] args) {

        int[][] intervals = {{1,3},
                {2,6},{8,10},{15,18}};
        int[][] re = new Simple56().merge(intervals);

        PKt.out(Arrays.deepToString(re));

    }

    /*
    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

 

示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 

提示：

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[0][1];

            int mSize = merged.size();

            if (mSize == 0 || merged.get(mSize - 1)[1] < l){
                merged.add(new int[]{l,r});
            }else{
                merged.get(mSize - 1)[1] = Math.max(merged.get(mSize - 1)[1],r);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
