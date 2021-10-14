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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while(prev.next!=null && prev.next.next!=null) {
            ListNode tmp = head.next.next;
            prev.next = head.next;
            head.next.next = head;
            head.next = tmp;
            prev = head;
            head = head.next;
        }
        return dummyNode.next;
    }
}
