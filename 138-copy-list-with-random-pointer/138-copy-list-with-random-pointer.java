/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node dummyNode = new Node(0);
        Node prev = dummyNode;
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            prev.next = newNode;
            prev = newNode;
            map.put(temp, newNode);
            temp = temp.next;
        }
        temp = head;
        Node temp1 = dummyNode.next;
        while (temp != null) {
            Node random = map.get(temp.random);
            temp1.random = random;
            temp = temp.next;
            temp1 = temp1.next;
        }
        return dummyNode.next;
    }
}