package pri.jv.sort;

/**
 * @ClassName SelectionSort
 * @Dscription
 * @Date 2/22/21
 * @Author JV
 **/
public class SelectionSort {

    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j]<nums[min]){
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }
}
