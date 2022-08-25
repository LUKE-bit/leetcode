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
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(k <= 1)return head;
        if(head==null) return head;
        int len = length(head);
        int nums = len / k;
        ListNode numpNode = new ListNode(-1);
        ListNode cur = numpNode;
        for(int i = 0;i < nums;i++) {
            ListNode tmp = null;
            for(int j = 0;j < k;j++) {
                ListNode temp = head.next;
                head.next = tmp;
                tmp = head;
                head = temp;
            }
            cur.next = tmp;
            while(cur.next!=null) cur = cur.next;
        }
        cur.next = head;
        return numpNode.next;
    }
     public int length(ListNode now){    //获取链表长度
        int cnt = 0;
        if(now != null) cnt = 1;
        while(now.next != null){
            cnt ++; now = now.next;
        }
        return cnt;
    }
}
