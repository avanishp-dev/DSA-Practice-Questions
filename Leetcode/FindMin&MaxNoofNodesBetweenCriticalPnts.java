/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int prev = -1;
        int minDist = Integer.MAX_VALUE;
        int pos = 1;
        ListNode prevNode = head;
        ListNode curr = head.next;
        while (curr != null && curr.next != null) {
            int nextVal = curr.next.val;
            boolean critical =
                    (curr.val > prevNode.val && curr.val > nextVal) ||
                    (curr.val < prevNode.val && curr.val < nextVal);
            if (critical) {
                if (first == -1) {
                    first = pos;
                } else {
                    minDist = Math.min(minDist, pos - prev);
                }
                prev = pos;
            }
            prevNode = curr;
            curr = curr.next;
            pos++;
        }
        if (first == -1 || first == prev) {
            return new int[]{-1, -1};
        }
        return new int[]{minDist, prev - first};
    }
}