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
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail (ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode left = head;
        ListNode right = head;
        while(right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        if(right != null) {
            left = left.next;
        }
        left = reverse(left);
        while(left != null) {
            if(head.val != left.val){
                return false;
            }
            head = head.next;
            left = left.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
////////////////////
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
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail (ListNode head) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while(cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while(!stack.isEmpty()){
            if(stack.pop() != cur.val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
}
