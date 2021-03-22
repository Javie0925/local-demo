package pri.jv.leetcode;

import java.util.HashSet;

/**
 * @ClassName Solution817
 * @Dscription
 * @Date 3/11/21
 * @Author JV
 **/
public class Solution817 {

    public int numComponents(ListNode head, int[] G) {
        if (head == null || G.length == 0) {
            return 0;
        }
        int result = 0;
        ListNode root = head;
        ListNode current = null;
        HashSet<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        while (root != null) {
            if (set.contains(root.val)) {
                current = root.next;
                while (current != null && set.contains(current.val)) {
                    current = current.next;
                }
                result++;
                if (current != null) {
                    root = current.next;
                } else {
                    break;
                }
            }else {
                root = root.next;
            }
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution817 solution817 = new Solution817();
        ListNode listNode0 = solution817.new ListNode(0);
        ListNode listNode1 = solution817.new ListNode(1);
        ListNode listNode2 = solution817.new ListNode(2);
        ListNode listNode3 = solution817.new ListNode(3);

        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        int[] arr = {0,1,3};
        solution817.numComponents(listNode0,arr);
    }
}
