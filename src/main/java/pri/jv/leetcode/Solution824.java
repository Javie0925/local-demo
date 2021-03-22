package pri.jv.leetcode;

/**
 * @ClassName Solution824
 * @Dscription
 * @Date 3/12/21
 * @Author JV
 **/
public class Solution824 {
    public String toGoatLatin(String S) {
        String pattern = "^[aeiouAEIOU]";
        String[] strs = S.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].matches(pattern)) {
                strs[i] = strs[i] + "ma";
            } else {
                String s = strs[i].replaceFirst(strs[i].substring(0, 1), "");
                s = s + strs[i].substring(0, 1) + "ma";
                strs[i] = s;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            StringBuilder appendA = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                appendA.append("a");
            }
            if (i == strs.length - 1) {
                sb.append(strs[i]).append(appendA);
            }
            sb.append(strs[i]).append(appendA).append("");
        }
        return sb.toString();
    }
}
