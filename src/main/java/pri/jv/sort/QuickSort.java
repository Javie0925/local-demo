package pri.jv.sort;

/**
 * @ClassName QuickSort
 * @Dscription
 * @Date 2/22/21
 * @Author JV
 **/
public class QuickSort {

    public void quickSort(int[] nums, int from, int to) {
        if (!(from < to)) {
            return;
        }
        int povit = from;
        for (int i = from + 1; i <= to && povit + 1 <= to; i++) {
            if (nums[i] < nums[povit] && i > povit) {
                if (i == povit + 1) {
                    int temp = nums[povit];
                    nums[povit] = nums[i];
                    nums[i] = temp;
                } else {
                    int temp = nums[povit + 1];
                    nums[povit + 1] = nums[povit];
                    nums[povit] = nums[i];
                    nums[i] = temp;
                }
                povit = povit + 1;
            }
        }
        quickSort(nums, from, povit - 1);
        quickSort(nums, povit + 1, to);
    }
}
