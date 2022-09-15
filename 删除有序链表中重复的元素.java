import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if(head == null) {
            return head;
        }
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode cur = res;
        while(cur.next!=null && cur.next.next != null) {
            if(cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                while(cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return res.next;
    }
}
