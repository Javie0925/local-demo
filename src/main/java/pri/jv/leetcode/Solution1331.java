package pri.jv.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName Solution1331
 * @Dscription
 * @Date 3/3/21
 * @Author JV
 **/
public class Solution1331 {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pos = 1;
        int[] ints = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])){
                map.put(arr[i],pos++);
            }
        }
        for (int i=0;i<ints.length;i++){
            arr[i] = map.get(ints[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution1331 solution1331 = new Solution1331();
        int[] arr = {40,10,20,30};
        solution1331.arrayRankTransform(arr);
    }
}
