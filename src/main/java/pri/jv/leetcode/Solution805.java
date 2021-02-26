package pri.jv.leetcode;

//给定的整数数组 A ，我们要将 A数组 中的每个元素移动到 B数组 或者 C数组中。（B数组和C数组在开始的时候都为空）
//
// 返回true ，当且仅当在我们的完成这样的移动后，可使得B数组的平均值和C数组的平均值相等，并且B数组和C数组都不为空。
//
//
//示例:
//输入:
//[1,2,3,4,5,6,7,8]
//输出: true
//解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
//
//
// 注意:
//
//
// A 数组的长度范围为 [1, 30].
// A[i] 的数据范围为 [0, 10000].
//
// Related Topics 数学
// 👍 58 👎 0


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution805 {

    public boolean splitArraySameAverage(int[] A) {
        if (A.length==2){
            return A[0]==A[1];
        }
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        for (int i=1;i<=A.length/2;i++){
            int[] B = new int[i];
            boolean split = split(list, B, 0);
            if (split) {
                return split;
            }
        }
        return false;
    }

    boolean split(List<Integer> list,int[] B,int p){
        if (p>=B.length){
            return calculate(list,B);
        }
        for (int i = 0;i<list.size();i++){
            Integer remove = list.remove(i);
            B[p] = remove;
            boolean split = split(list, B, p + 1);
            if (!split){
                list.add(i,remove);
            }else {
                return true;
            }
        }
        return false;
    }

    private boolean calculate(List<Integer> A, int[] B) {
        int sumA = 0,modA=0,avgA=0;
        int sumB = 0,modB=0,avgB=0;
        for (int i=0;i<A.size();i++){
            sumA+=A.get(i);
        }
        avgA = sumA/A.size();
        modA = sumA%A.size();
        for (int i=0;i<B.length;i++){
            sumB += B[i];
        }
        avgB = sumB/B.length;
        modB = sumB%B.length;

        return avgA == avgB && modA*B.length==modB*A.size();
    }

    public static void main(String[] args) {
        Solution805 solution805 = new Solution805();
        int[] A = {60,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30};
        boolean b = solution805.splitArraySameAverage(A);
        System.out.println(b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

