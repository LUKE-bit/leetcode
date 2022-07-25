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
// 给定一个单链表 L 的头节点 head ，单链表 L 表示为：

// L0 → L1 → … → Ln - 1 → Ln
// 请将其重新排列后变为：

// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while(cur!=null){
            list.add(cur);
            cur = cur.next;
        }
        int i = 0,j = list.size()-1;
        while(i<j){
            list.get(i).next = list.get(j);
            i++;
            if(i==j)break;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next=null;
    }
}

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
    public void reorderList(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = head;
        ListNode mid = middleNode(l1);
        l2 = reverse(mid.next);
        mid.next = null;
        l1 = merge(l1,l2);

    }
    public ListNode middleNode(ListNode cur){
        ListNode slow = cur;
        ListNode fast = cur;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
    public ListNode merge(ListNode l1,ListNode l2) {
        ListNode ans = l1;
        ListNode l1_tmp;
        ListNode l2_tmp;
        while(l1!=null && l2!=null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
        return ans;
    }
}
