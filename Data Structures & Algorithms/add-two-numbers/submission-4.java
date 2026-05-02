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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1, c2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (c1 != null || c2 != null || carry != 0) {
            int n1 = c1 != null ? c1.val : 0;
            int n2 = c2 != null ? c2.val : 0;
            int sum = (n1 + n2 + carry);

            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;

            curr.next = node;
            curr = curr.next;

            c1 = c1 == null ? c1 : c1.next;
            c2 = c2 == null ? c2 : c2.next;
        }

        return dummy.next;
        
    }
}
