package pri.jv.sort;

/**
 * @ClassName InsertionSort
 * @Dscription
 * @Date 2/22/21
 * @Author JV
 **/
public class InsertionSort {

    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j=i;
            while (j-1>=0 && nums[j-1]>nums[j]){
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                j--;
            }
        }
    }
}
