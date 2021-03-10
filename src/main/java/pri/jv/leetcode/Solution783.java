package pri.jv.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Solution783
 * @Dscription
 * @Date 3/8/21
 * @Author JV
 **/
public class Solution783 {
    List<Integer> list = new ArrayList<Integer>();
    public int minDiffInBST(TreeNode root) {
        iterate(root);
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for (int i=1;i<list.size();i++){
            int dif = list.get(i)-list.get(i-1);
            if (dif < min){
                min = dif;
            }
        }
        return min;
    }

    public void iterate(TreeNode node){
        if (node==null){
            return;
        }
        list.add(node.val);
        iterate(node.left);
        iterate(node.right);
    }
}
