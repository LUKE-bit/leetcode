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
 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode node = head;
        int length = 0;
        while(node!=null){
            length++;
            node = node.next;
        }
        ListNode dummy = new ListNode(0,head);
        for(int sublength = 1;sublength < length;sublength<<=1) {
            ListNode prev = dummy,curr = dummy.next;
            while(curr!=null) {
                ListNode head1 = curr;
                for(int i = 1;i < sublength && curr.next!=null;i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for(int i = 1;i < sublength &&curr!=null&& curr.next!=null;i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if(curr!=null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1,head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummy.next;
    }
    public ListNode merge(ListNode head1,ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
