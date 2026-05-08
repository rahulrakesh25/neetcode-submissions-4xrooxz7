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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode recentStart = null;
        ListNode unfinieshed = head;
        ListNode newNode = null;

        int i = 1;
        while (head != null) {
            ListNode node = new ListNode(head.val, newNode);
            newNode = node;
            System.out.println("curr head val -> " + head.val);
            if (i % k == 0) {
                curr.next = newNode;
                curr = recentStart;
                newNode = null;
            }
            if (i % k == 1) {
                recentStart = node;
                unfinieshed = head;
            }
            head = head.next;
            i++;
        }

        if ((i - 1) % k != 0) {
            curr.next = unfinieshed;
        }

        
        return dummy.next;
    }
}
