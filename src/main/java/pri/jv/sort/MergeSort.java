package pri.jv.sort;

/**
 * @ClassName MergeSort
 * @Dscription
 * @Date 2/23/21
 * @Author JV
 **/
public class MergeSort {

    public void mergeSort(int[] nums, int from, int to) {
        // 递归退出条件
        if (!(from < to)) {
            return;
        }
        int mid = (from + to) / 2;
        mergeSort(nums, from, mid);
        mergeSort(nums, mid + 1, to);
        int i = from, j = mid + 1;
        // 暂存数组
        int[] res = new int[to - from + 1];
        // 暂存数组位置指针
        int pos = 0;
        for (; i <= mid && j <= to; ) {
            if (nums[j] < nums[i]) {
                res[pos++] = nums[j++];
            } else {
                res[pos++] = nums[i++];
            }
        }
        // 处理剩余
        if (pos < res.length && i <= mid) {
            while ( i <= mid) {
                res[pos++] = nums[i++];
            }
        } else if (pos < res.length && j <= to) {
            while (j <= to) {
                res[pos++] = nums[j++];
            }
        }
        // 填回原数组
        for (int k = 0; k < res.length; ) {
            nums[from++] = res[k++];
        }
    }
}
