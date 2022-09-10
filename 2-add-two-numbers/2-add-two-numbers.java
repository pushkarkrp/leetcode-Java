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
        
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int unit = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(unit);
            prev.next = newNode;
            prev = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null || l2!= null) {
            ListNode temp =  l1 != null ? l1 : l2;
            while (temp != null) {
                int sum = temp.val + carry;
                int unit = sum % 10;
                carry = sum / 10;
                ListNode newNode = new ListNode(unit);
                prev.next = newNode;
                prev = newNode;
                temp = temp.next;
            }
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            prev.next = newNode;
        }
        
        return dummy.next;
    }
}