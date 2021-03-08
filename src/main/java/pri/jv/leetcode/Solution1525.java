package pri.jv.leetcode;

import java.util.HashSet;

/**
 * @ClassName Solution1525
 * @Dscription
 * @Date 3/4/21
 * @Author JV
 **/
public class Solution1525 {
    public int numSplits(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int[] head = new int[s.length()];
        int[] tail = new int[s.length()];
        HashSet<Character> headSet = new HashSet<>();
        HashSet<Character> tailSet = new HashSet<>();
        for (int i=0,j=s.length()-1;i<s.length()&&j>0;i++,j--){
            headSet.add(s.charAt(i));
            tailSet.add(s.charAt(j));
            head[i]=headSet.size();
            tail[j]=tailSet.size();
        }
        for (int i=0;i<s.length()-1;i++){
            if (head[i]==tail[i+1]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1525 s = new Solution1525();
        s.numSplits("aacaba");
    }
}
