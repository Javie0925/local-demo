package pri.jv.sort;

import java.util.Arrays;

/**
 * {9,2,4,7,1,6,3,5,8,0};
 * {2,4,7,1,6,3,5,8,0,9};
 * {1,0,2,4,7,6,3,5,8,9}
 * 0,1,2,3,4,5,6,7,8,9
 **/
public class Main {

    public static void main(String[] args) {
        int[] nums = {9, 2, 4, 7, 1, 6, 3, 5, 8, 0};
        // new BubbleSort().bubbleSort(nums);
        // new QuickSort().quickSort(nums,0,nums.length-1);
        // new InsertionSort().insertionSort(nums);
        // new ShellSort().shellSort(nums);
        // new SelectionSort().selectionSort(nums);
        // new HeapSort().heapSort(nums);
        // new MergeSort().mergeSort(nums, 0, nums.length - 1);
        // new CountingSort().countingSort(nums);
        // new BucketSort().bucketSort(nums,2);
        int[] nums2 = new int[]{999,4,7,34,56,78,90,123,1,345,546,1324};
        System.out.println(Arrays.toString(nums2));
        new RadixSort().radixSort(nums2);
        System.out.println(Arrays.toString(nums2));

    }

}
