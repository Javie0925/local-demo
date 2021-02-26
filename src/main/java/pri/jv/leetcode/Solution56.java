package pri.jv.leetcode;

//给出一个区间的集合，请合并所有重叠的区间。
//
//
//
// 示例 1:
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
//
//
//
// 提示：
//
//
// intervals[i][0] <= intervals[i][1]
//
// Related Topics 排序 数组
// 👍 786 👎 0

import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution56 {
    public int[][] merge(int[][] intervals) {
        sort(intervals);
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; ) {
            int[] ints1 = intervals[i];
            if (i + 1 < intervals.length && intervals[i][1] >= intervals[i + 1][0]) {
                int big = intervals[i][1];
                int j = i + 1;
                for (; j < intervals.length; j++) {
                    if (intervals[j][0] <= big) {
                        if (intervals[j][1] > big) {
                            big = intervals[j][1];
                        }
                    } else {
                        j--;
                        break;
                    }
                }
                list.add(new int[]{ints1[0], big});
                i = j + 1;
                continue;
            } else {
                list.add(intervals[i]);
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    void sort(int[][] arrs) {

        for (int i = arrs.length-1; i > 0; i--) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                if (arrs[j][0] > arrs[max][0]) {
                    max = j;
                }
            }
            int[] temp = arrs[i];
            arrs[i] = arrs[max];
            arrs[max] = temp;
        }
    }

    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[][] arrs = {{0, 1}, {3, 3}, {3, 4},{1,2},{4,5},{5,7},{3,4},{2,2}};
        int[][] merge = solution56.merge(arrs);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

