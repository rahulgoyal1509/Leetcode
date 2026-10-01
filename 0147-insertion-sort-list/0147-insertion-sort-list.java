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
    public ListNode insertionSortList(ListNode head) {
        ListNode temp = head;

        while(temp.next != null){
            if (temp.val <= temp.next.val){
                temp = temp.next;
                continue;
            }

            ListNode node = temp.next;
            temp.next = node.next;
            
            ListNode curr = head, prev = null;

            while(curr != temp && curr.val <= node.val){
                prev = curr;
                curr = curr.next;
            }

            if (prev == null){
                node.next = head;
                head = node;
            }
            else{
                node.next = prev.next;
                prev.next = node;
            }
        }

        return head;
    }
}