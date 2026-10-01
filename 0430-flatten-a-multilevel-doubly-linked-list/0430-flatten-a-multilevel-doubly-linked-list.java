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
    public void flat(Node head, Node newHead){
        Node temp = head, curr = newHead;
        Node newNode = new Node(temp.val);
        
        curr.next = newNode;
        newNode.prev = curr;
        curr = curr.next;

        while(temp != null){
            Node next = temp.next;
            if (temp.child != null){
                flat(temp.child, curr);
            }

            temp = temp.next;
            if (temp != null){
                temp = next;
                while(curr.next != null){
                    curr = curr.next;
                }

                newNode = new Node(temp.val);
                curr.next = newNode;
                newNode.prev = curr;
                curr = curr.next;
            }
        }
    }

    public Node flatten(Node head) {
        if (head == null) return null;
        Node newHead = new Node(-1);

        flat(head, newHead);

        // Node temp = newHead;
        // newHead = newHead.next;
        // temp.next = null;
        // newHead.prev = null;
        // return newHead;

        newHead.next.prev = null;
        return newHead.next;
    }
}