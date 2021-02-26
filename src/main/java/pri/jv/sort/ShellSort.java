package pri.jv.sort;

/**
 * @ClassName ShellSort
 * @Dscription
 * @Date 2/22/21
 * @Author JV
 **/
public class ShellSort {

    public void shellSort(int[] nums) {
        for (int span = nums.length / 2; span > 0; span--) {
            for (int i = span; i < nums.length; i++) {
                if (nums[i] < nums[i - span]) {
                    int temp = nums[i];
                    nums[i] = nums[i - span];
                    nums[i - span] = temp;
                }
            }
        }
    }
}
