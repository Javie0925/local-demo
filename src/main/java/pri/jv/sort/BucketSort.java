package pri.jv.sort;

/**
 * @ClassName BucketSort
 * @Dscription
 * @Date 2/23/21
 * @Author JV
 **/
public class BucketSort {

    public void bucketSort(int[] nums, int bucketNum) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = nums[i] > max ? nums[i] : max;
        }
        int base = max / bucketNum;
        int[][] res = new int[bucketNum][nums.length];
        int[] count = new int[bucketNum];
        for (int i = 0; i < nums.length; i++) {
            // 确定桶位置
            int dest = nums[i] / base;
            if (dest >= res.length) {
                dest--;
            }
            // 插入桶中，并对其排序
            for (int j = 0; j <= count[dest]; j++) {
                if (j == count[dest]) {
                    res[dest][j] = nums[i];
                    count[dest] += 1;
                    break;
                }
                if (nums[i] > res[dest][j]) {
                    continue;
                } else {
                    int k = j;
                    for (int temp; k <= count[dest]; k++) {
                        temp = res[dest][k];
                        res[dest][k] = nums[i];
                        nums[i] = temp;
                    }
                    count[dest] += 1;
                    break;
                }
            }
        }
        // 合并桶数组数据返回
        int numsPos = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[numsPos++] = res[i][j];
            }
        }

    }
}
