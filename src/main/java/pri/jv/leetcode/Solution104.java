package pri.jv.leetcode;

//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索 递归
// 👍 803 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution104 {

    private List<TreeNode> stack = new ArrayList<>();
    private int max = 0;

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        stack.add(root);
        doMaxDepth();
        return max;
    }

    public void doMaxDepth(){
        if(stack.size()==0){
            return;
        }
        if (stack.size()>max){
            max = stack.size();
        }
        TreeNode node = stack.get(stack.size()-1);
        if (null != node.left){
            stack.add(node.left);
            doMaxDepth();
            stack.remove(node.left);
        }
        if (null != node.right){
            stack.add(node.right);
            doMaxDepth();
            stack.remove(node.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

