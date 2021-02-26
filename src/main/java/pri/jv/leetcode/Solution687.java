package pri.jv.leetcode;
//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。
//
// 示例 1:
//
// 输入:
//
//
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
//
//
// 输出:
//
//
//2
//
//
// 示例 2:
//
// 输入:
//
//
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
//
//
// 输出:
//
//
//2
//
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
// Related Topics 树 递归
// 👍 417 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 1
 * \
 * 1
 * / \
 * 1    1
 * / \
 * 1    1
 * /
 * 1
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution687 {

    private List<Integer> list = new ArrayList<>();

    public int longestUnivaluePath(TreeNode root) {

        longestPath(root);

        int max = 0;
        for (Integer i : list) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public int longestPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftVal = 0, rightVal = 0;
        if (root.left != null) {
            if (root.left.val == root.val) {
                leftVal = longestPath(root.left) + 1;
            } else {
                longestPath(root.left);
                leftVal = 0;
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val) {
                rightVal = longestPath(root.right) + 1;
            } else {
                longestPath(root.right);
                rightVal = 0;
            }
        }
        list.add(leftVal + rightVal);
        return leftVal > rightVal ? leftVal : rightVal;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
