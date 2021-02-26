package pri.jv.sort;

/**
 * @ClassName RadixSort
 * @Dscription
 * @Date 2/23/21
 * @Author JV
 **/
public class RadixSort {
    public void radixSort(int[] nums) {
        int max = nums[0];
        // 找出最大值
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int maxLen = 1;
        // 求最大值位数
        while ((max /= 10) != 0) {
            maxLen++;
        }
        // 排序
        for (int i = 1; i <= maxLen; i++) {
            int[][] res = new int[10][nums.length];
            int[] count = new int[10];
            for (int j = 0; j < nums.length; j++) {
                // 求第i位上的数字
                int dest = nums[j] % ((int) Math.pow(10L, (long) i)) / (int) Math.pow(10L, (long) i - 1);
                res[dest][count[dest]] = nums[j];
                count[dest] += 1;
            }
            // 取出结果，进行下一位排序
            int numsPos = 0;
            for (int k = 0; k < 10; k++) {
                for (int n = 0; n < count[k]; n++) {
                    nums[numsPos++] = res[k][n];
                }
            }
        }
    }
}
