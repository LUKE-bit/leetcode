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
    public ListNode middleNode(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        int count = 0;
        int step = 0;
        for(;right.next!=null;right = right.next) {
            count++;
        }
        step = (count+1)/2;
        while(step!=0) {
            head = head.next;
            step--;
        }
        return head;
    }
}
