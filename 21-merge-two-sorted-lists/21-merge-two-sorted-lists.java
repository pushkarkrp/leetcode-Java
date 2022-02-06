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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for(ListNode node : lists) {
            if(node != null)
                minHeap.add(node);
        }
        if(minHeap.size() == 0) return head;
        head = minHeap.poll();
        ListNode prev = head;
        if(head.next != null) minHeap.add(head.next);
        while(!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            prev.next = temp;
            prev = temp;
            if(temp.next != null) {
                minHeap.add(temp.next);
            }
        }
        return head;
    }
}