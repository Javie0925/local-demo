package pri.jv.leetcode;

import java.util.HashSet;
import java.util.List;

/**
 * @ClassName Solution139
 * @Dscription
 * @Date 2/25/21
 * @Author JV
 **/
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] d = new boolean[s.length()+1];
        d[0] = true;
        for (int i = 1;i<=s.length();i++){
            for (int j=0;j<i;j++){
                if (d[j] && wordDictSet.contains(s.substring(j,i))){
                    d[i] = true;
                    break;
                }
            }
        }
        return d[s.length()];
    }
}
