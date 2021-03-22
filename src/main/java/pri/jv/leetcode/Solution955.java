package pri.jv.leetcode;

/**
 * @ClassName Solution955
 * @Dscription
 * @Date 3/15/21
 * @Author JV
 **/
public class Solution955 {
    public int minDeletionSize(String[] strs) {
        int len = strs[0].length();
        int result = 0;
        for (int i = 0; i < len;) {
            if (isStrictDictOrderd(strs,i)){
                return result;
            } else if (isDictOrderd(strs,i)){
                i++;
                continue;
            } else {
                removeColunm(strs,i);
                len--;
                result++;
            }
        }
        return result;
    }

    private void removeColunm(String[] strs,int pos){
        for (int i=0;i<strs.length;i++){
            strs[i] = strs[i].substring(0,pos)+strs[i].substring(pos+1,strs[i].length());
        }
    }

    private boolean isStrictDictOrderd(String[] strs, int pos) {
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].substring(0, pos+1).compareTo(strs[i - 1].substring(0, pos+1)) <= 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isDictOrderd(String[] strs, int pos) {
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].substring(0, pos+1).compareTo(strs[i - 1].substring(0, pos+1)) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution955 solution955 = new Solution955();
        String[] strs = {"ca","bb","ac"};
        int i = solution955.minDeletionSize(strs);
        System.out.println(i);
    }
}
