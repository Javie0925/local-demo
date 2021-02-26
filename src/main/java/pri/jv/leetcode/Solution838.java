package pri.jv.leetcode;

/**
 * @ClassName Solution838
 * @Dscription
 * @Date 1/28/21
 * @Author JV
 **/
public class Solution838 {
    public String pushDominoes(String dominoes) {
        char[] charArr = dominoes.toCharArray();

        int length = charArr.length;
        for (int i = 0; i < length - 1; ) {
            int start = dominoes.indexOf('.', i);
            if (start==-1){
                break;
            }
            int end = start;
            for (int j = start + 1; j < dominoes.length(); j++) {
                if (dominoes.charAt(j) == '.') {
                    end++;
                } else {
                    break;
                }
            }
            if (start == 0) {
                if (end + 1 < dominoes.length() && dominoes.charAt(end + 1) == 'L') {
                    while (start <= end) {
                        charArr[start++] = 'L';
                    }
                }
            } else if (end == dominoes.length() - 1) {
                if (dominoes.charAt(start - 1) == 'R') {
                    while (start <= end) {
                        charArr[start++] = 'R';
                    }
                }
            }  else if (dominoes.charAt(start - 1) == 'L' && dominoes.charAt(end + 1) == 'L') {
                while (start <= end) {
                    charArr[start++] = 'L';
                }
            } else if (dominoes.charAt(start - 1) == 'R' && dominoes.charAt(end + 1) == 'R') {
                while (start <= end) {
                    charArr[start++] = 'R';
                }
            } else if (dominoes.charAt(start - 1) == 'R' && dominoes.charAt(end + 1) == 'L'){
                int end_ = end;
                while (start < end_) {
                    charArr[start++] = 'R';
                    charArr[end_--] = 'L';
                }
            }
            i = end + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : charArr) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution838 solution838 = new Solution838();
        System.out.println("LLLL.RLLLL.L....RLLRL.LLL..L...L.L.RL.L....LLLRL.......L....LLLLLL....LL.L...LL..LRL.RLRLLL.L.....LR");
        System.out.println(solution838.pushDominoes("LLLL.RLLLL.L....RLLRL.LLL..L...L.L.RL.L....LLLRL.......L....LLLLLL....LL.L...LL..LRL.RLRLLL.L.....LR"));
    }
}