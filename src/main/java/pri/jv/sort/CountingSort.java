package pri.jv.sort;

/**
 * @ClassName CountingSort
 * @Dscription
 * @Date 2/23/21
 * @Author JV
 **/
public class CountingSort {

    public void countingSort(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int[] res = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            res[nums[i] - min] += 1;
        }
        for (int i = 0, k = 0; i < res.length; i++) {
            for (int j = 0; j < res[i]; j++) {
                nums[k++] = i + min;
            }
        }

    }
}
