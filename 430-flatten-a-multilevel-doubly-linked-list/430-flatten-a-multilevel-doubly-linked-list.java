/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node tail = null;
    public Node flatten(Node head) {
        if (head == null) return head;
        Node pointer = head;
        
        while (pointer != null) {
            if (pointer.child == null) {
                pointer = pointer.next;
                continue;
            }
            Node nextNode = pointer.next;
            Node temp = pointer.child;
            while (temp.next != null) {
                temp = temp.next;
            }
            pointer.next = pointer.child;
            pointer.child.prev = pointer;
            pointer.child = null;
            temp.next = nextNode;
            if (nextNode != null)
                nextNode.prev = temp;
            pointer = pointer.next;
        }

        return head;
    }
}