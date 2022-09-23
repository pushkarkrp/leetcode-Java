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
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode head;
        while (temp1!=null) {
            stack1.push(temp1.val);
            temp1 = temp1.next;
        }
        while (temp2!=null) {
            stack2.push(temp2.val);
            temp2 = temp2.next;
        }
        int carry = 0;
        ListNode nextNode = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = 0;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            sum += carry;
            carry = sum / 10;
            int unit = sum % 10;
            ListNode newNode = new ListNode(unit);
            newNode.next = nextNode;
            nextNode = newNode;
        }
        if ( carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = nextNode;
            nextNode = newNode;
        }
        return nextNode;
    }
}