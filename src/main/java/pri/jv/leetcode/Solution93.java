package pri.jv.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution93
 * @Dscription
 * @Date 3/10/21
 * @Author JV
 **/
public class Solution93 {
    List<String> list = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {
        doRestoreIpAddresses(s, 0, "", 0);
        return list;
    }

    private void doRestoreIpAddresses(String s, int from, String str, int round) {
        if (round < 3 && from < s.length() && "0".equals(s.substring(from, from + 1))) {
            String toAppend;
            if (round == 0) {
                toAppend = "0";
            } else {
                toAppend = ".0";
            }
            doRestoreIpAddresses(s, from + 1, str + toAppend, round + 1);
            return;
        }
        if (round == 3 && from < s.length() && s.substring(from, from + 1).equals("0") && s.length() - from > 1) {
            return;
        }
        String subStr = "";
        if (round == 3) {
            for (int i = from; i < s.length(); i++) {
                if (s.substring(i, i + 1).matches("[0-9]+")) {
                    subStr += s.substring(i, i + 1);
                }
            }
            if (subStr.length()==0 || subStr.length()>3){
                return;
            }
            if (Integer.parseInt(subStr) <= 255) {
                list.add(str + "." + subStr);
            }
            return;
        }
        for (int i = from; subStr.length() <= 3 && i < s.length(); i++) {
            if (s.substring(i, i + 1).matches("[0-9]+")) {
                subStr += s.substring(i, i + 1);
                int num = Integer.parseInt(subStr);
                if (num <= 255) {
                    String toAppend;
                    if (round == 0) {
                        toAppend = subStr;
                    } else {
                        toAppend = "." + subStr;
                    }
                    doRestoreIpAddresses(s, i + 1, str + toAppend, round + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution93 s = new Solution93();
        List<String> strings = s.restoreIpAddresses("0279245587303");
        System.out.println(strings);
    }

}
