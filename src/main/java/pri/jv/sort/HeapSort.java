package pri.jv.sort;

/**
 * @ClassName HeapSort
 * @Dscription
 * @Date 2/22/21
 * @Author JV
 **/
public class HeapSort {

    public void heapSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (nums[j] > nums[(j - 1) / 2]) {
                    int temp = nums[j];
                    nums[j] = nums[(j - 1) / 2];
                    nums[(j - 1) / 2] = temp;
                }
            }
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
        }
    }
}
