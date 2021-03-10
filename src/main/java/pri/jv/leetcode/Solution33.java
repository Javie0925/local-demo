package pri.jv.leetcode;

/**
 * @ClassName Solution33
 * @Dscription
 * @Date 3/10/21
 * @Author JV
 **/
public class Solution33 {
    public int search(int[] nums, int target) {
        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                pos = i;
            }
        }
        int res = 0;
        if (target <= nums[nums.length - 1]) {
            return splitSearch(nums, pos, nums.length,target);
        } else {
            return splitSearch(nums, 0, pos,target);
        }
    }

    public int splitSearch(int[] nums, int from, int to, int target) {

        for (int mid = (from + to) / 2; from < to; mid = (from + to) / 2) {
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                from = mid+1;
            } else if (nums[mid] > target) {
                to = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int[] nums = {4,5,6,7,0,1,2};
        int search = solution33.search(nums, 4);
        System.out.println(search);
    }
}
