package pri.jv.sort;

/**
 * @ClassName BubbleSort
 * @Dscription
 * @Date 2/22/21
 * @Author JV
 **/
public class BubbleSort {

    public void bubbleSort(int[] nums){
        for (int i=nums.length-1;i>0;i--){
            for (int j=1;j<=i;j++){
                if (nums[j-1]>nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
    }
}
