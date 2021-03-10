package pri.jv.leetcode;

/**
 * @ClassName Solution125
 * @Dscription
 * @Date 3/9/21
 * @Author JV
 **/
public class Solution125 {
    public boolean isPalindrome(String s) {
        int head = 0,tail = s.length()-1;
        while (head<tail){
            while (!s.substring(head,head+1).matches("[a-zA-Z0-9]+")){
                head++;
            }
            while (!s.substring(tail,tail+1).matches("[a-zA-Z0-9]+")){
                tail--;
            }
            if (!s.substring(head,head+1).toLowerCase().equals(s.substring(tail,tail+1).toLowerCase())){
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution125 s = new Solution125();
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println("0".matches("[a-zA-Z0-9]"));
    }
}
