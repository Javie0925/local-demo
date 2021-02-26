package pri.jv.leetcode;

/**
 * @ClassName Solution42
 * @Dscription
 * @Date 1/28/21
 * @Author JV
 **/
public class Solution42 {
    /**
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; ) {
            int start = 0, end = 0, temp = 0;
            if (height[i] > 0) {
                start = i;
                int tempMax = 0;
                int tempMaxIndex = 0;
                for (int j = i + 1; j < height.length; j++) {
                    if (height[j] >= height[start]) {
                        end = j;
                        break;
                    } else {
                        int h = height[j];
                        if (h >= tempMax) {
                            tempMaxIndex = j;
                            tempMax = h;
                        }
                    }
                    end = tempMaxIndex;
                }
                if (end > start + 1) {
                    for (int x = start + 1; x < end;x++) {
                        temp += height[x];
                    }
                    sum += (height[end] < height[start] ? height[end] * (end - start - 1) : height[start] * (end - start - 1)) - temp;
                }
            }
            i = end > 0 ? end : (i + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int trap = solution42.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(trap);
    }
}
