package pri.jv.leetcode;

import java.util.Arrays;

/**
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * <p>
 *  pre 和 post 遍历中的值是不同的正整数。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：      [1,2,3,4,5,6,7]
 * <p>
 * 提示：
 * <p>
 * 1 <= pre.length == post.length <= 30
 * pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
 * 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution889 {
    //* 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
    //* 输出：[1,2,3,4,5,6,7]
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return root;
        }
        int L = 0;
        for (int i = 0; i < post.length; i++) {
            if (post[i] == pre[1]) {
                L = i + 1;
                break;
            }
        }
        TreeNode left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1), Arrays.copyOfRange(post, 0, L));
        if (left != null) {
            root.left = left;
        }
        TreeNode right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, pre.length), Arrays.copyOfRange(post, L + 1, post.length));
        if (right != null) {
            root.right = right;
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

//Definition for a binary tree node.

