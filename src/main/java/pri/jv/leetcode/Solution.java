package pri.jv.leetcode;

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
 * } 3 5 1 6 2 0 8 null null 7 4 null null null null
 */

class Solution {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        Solution solution = new Solution();
        TreeNode treeNode = solution.lcaDeepestLeaves(root);
        System.out.println(treeNode.val);

    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        int pointer = 0;
        while (pointer < nodeList.size()) {
            TreeNode node = nodeList.get(pointer);
            if (node != null) {
                nodeList.add(node.left);
                nodeList.add(node.right);
                pointer++;
            } else {
                pointer++;
            }
        }
        //去除尾部空节点
        for (int i = nodeList.size() - 1; i >= 0; i--) {
            if (nodeList.get(i) == null) {
                nodeList.remove(i);
            } else {
                break;
            }
        }
        //确定尾部节点层级
        int sum = 0;
        int level = 1;
        for(int i=1;i>0;i*=2,level++){
            sum += i;
            if (nodeList.size()<=sum){
                sum-=i;
                break;
            }
        }
        List<Integer> child = new ArrayList<>();
        for (int i = sum; i < nodeList.size(); i++) {
            if (nodeList.get(i) != null) {
                child.add(i+1);
            }
        }
        if (child.size() == 1) {
            return nodeList.get(child.get(0));
        }
        int result = 0;
        while (true) {
            List<Integer> father = new ArrayList<>();
            for (Integer i : child) {
                int f = i/2;
                if (!father.contains(f)) {
                    father.add(f);
                }
            }
            if (father.size() > 1) {
                child = father;
            } else {
                result = father.get(0);
                break;
            }
        }
        return nodeList.get(result-1);

    }
}
