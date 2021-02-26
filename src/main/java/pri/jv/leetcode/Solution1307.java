package pri.jv.leetcode;

//给你一个方程，左边用 words 表示，右边用 result 表示。
//
// 你需要根据以下规则检查方程是否可解：
//
//
// 每个字符都会被解码成一位数字（0 - 9）。
// 每对不同的字符必须映射到不同的数字。
// 每个 words[i] 和 result 都会被解码成一个没有前导零的数字。
// 左侧数字之和（words）等于右侧数字（result）。
//
//
// 如果方程可解，返回 True，否则返回 False。
//
//
//
// 示例 1：
//
// 输入：words = ["SEND","MORE"], result = "MONEY"
//输出：true
//解释：映射 'S'-> 9, 'E'->5, 'N'->6, 'D'->7, 'M'->1, 'O'->0, 'R'->8, 'Y'->'2'
//所以 "SEND" + "MORE" = "MONEY" ,  9567 + 1085 = 10652
//
// 示例 2：
//
// 输入：words = ["SIX","SEVEN","SEVEN"], result = "TWENTY"
//输出：true
//解释：映射 'S'-> 6, 'I'->5, 'X'->0, 'E'->8, 'V'->7, 'N'->2, 'T'->1, 'W'->'3', 'Y'->
//4
//所以 "SIX" + "SEVEN" + "SEVEN" = "TWENTY" ,  650 + 68782 + 68782 = 138214
//
// 示例 3：
//
// 输入：words = ["THIS","IS","TOO"], result = "FUNNY"
//输出：true
//
//
// 示例 4：
//
// 输入：words = ["LEET","CODE"], result = "POINT"
//输出：false
//
//
//
//
// 提示：
//
//
// 2 <= words.length <= 5
// 1 <= words[i].length, results.length <= 7
// words[i], result 只含有大写英文字母
// 表达式中使用的不同字符数最大为 10
//
// Related Topics 数学 回溯算法
// 👍 42 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1307 {

    List<Integer> nums = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
    ArrayList<Character> chars = new ArrayList<>();
    int[] mapNums;

    public boolean isSolvable(String[] words, String result) {

        String[] allStrs = Arrays.copyOf(words, words.length + 1);
        allStrs[allStrs.length-1]=result;
        outer:for (int i=0;i<allStrs.length;i++){
            for (int j=0;j<allStrs[i].length();j++){
                if (chars.size()==10){
                    break outer;
                }
                if (!chars.contains(allStrs[i].charAt(j))) {
                    chars.add(allStrs[i].charAt(j));
                }
            }
        }
        mapNums = new int[chars.size()];
        int rest = chars.size();
        return iterate(rest,allStrs,result);
    }

    public boolean iterate(int rest,String[] words,String result){
        if (rest<=0){
            boolean calculate = calculate(result, words);
            return calculate;
        } else {
            int from = chars.size() - rest;
            for (int i=0;i<nums.size();i++){
                int num = nums.remove(i);
                mapNums[from] = num;
                boolean isTrue = iterate( rest-1,words,result);
                if (!isTrue){
                    nums.add(i,num);
                    mapNums[from] = -1;
                } else {
                    return isTrue;
                }
            }
        }
        return false;
    }

    public boolean calculate(String result,String... words){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0;i<mapNums.length;i++){
            map.put(chars.get(i),mapNums[i]);
        }
        String[] wordToNumStrArr = new String[words.length-1];
        for (int i=0;i<words.length-1;i++){
            String numStr = "";
            for (int j=0;j<words[i].length();j++){
                if (j==0&&map.get(words[i].charAt(j)).equals(0)){
                    return false;
                }
                numStr += map.get(words[i].charAt(j));
            }
            wordToNumStrArr[i] = numStr;
        }
        String resultNum = "";
        for (int i=0;i<result.length();i++){
            if (i==0&&map.get(result.charAt(i)).equals(0)){
                return false;
            }
            resultNum += map.get(result.charAt(i));
        }
        int leftVal = 0;
        for (int i=0;i<wordToNumStrArr.length;i++){
            leftVal += Integer.parseInt(wordToNumStrArr[i]);
        }
        int resultVal = Integer.parseInt(resultNum);
        return leftVal == resultVal;
    }

    public static void main(String[] args) {
        Solution1307 solution1307 = new Solution1307();
        String[] strs = {"SEND","MORE"};
        boolean money = solution1307.isSolvable(strs, "MONEY");
        System.out.println(money);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

