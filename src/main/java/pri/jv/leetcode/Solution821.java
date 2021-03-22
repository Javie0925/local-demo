package pri.jv.leetcode;

/**
 * @ClassName Solution821
 * @Dscription
 * @Date 3/11/21
 * @Author JV
 **/
public class Solution821 {
    public int[] shortestToChar(String s, char c) {
        int pos = 0;
        int[] arr = new int[s.length()];
        boolean init = true;
        for (int lastIndexOf = 0,indexOf = s.indexOf(c, 0); pos < s.length(); ) {
            if (init) {
                for (; pos <= indexOf; pos++) {
                    arr[pos] = indexOf - pos;
                }
            } else {
                indexOf = s.indexOf(c, lastIndexOf+1);
            }
            if (pos > lastIndexOf && pos <= indexOf) {
                for (; pos <= indexOf; pos++) {
                    arr[pos] = Math.min(pos - lastIndexOf, indexOf - pos);
                }
            } else if (indexOf == -1) {
                for (; pos < s.length(); pos++) {
                    arr[pos] = pos - lastIndexOf;
                }
            }
            init = false;
            lastIndexOf = indexOf;
        }

        return arr;
    }

    public static void main(String[] args) {
        Solution821 solution821 = new Solution821();
        solution821.shortestToChar("loveleetcode",'e');
    }
}
