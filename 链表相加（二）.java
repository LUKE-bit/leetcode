import java.util.*;
public class Solution {
    //反转链表
    public ListNode ReverseList(ListNode pHead) { 
        if(pHead == null)
            return null;
        ListNode cur = pHead;
        ListNode pre = null;
        while(cur != null){
            //断开链表，要记录后续一个
            ListNode temp = cur.next;
            //当前的next指向前一个
            cur.next = pre; 
            //前一个更新为当前
            pre = cur; 
            //当前更新为刚刚记录的后一个
            cur = temp; 
        }
        return pre;
    }
    
    public ListNode addInList (ListNode head1, ListNode head2) {
        //任意一个链表为空，返回另一个
        if(head1 == null) 
            return head2;
        if(head2 == null)
            return head1;
        //反转两个链表
        head1 = ReverseList(head1); 
        head2 = ReverseList(head2);
        //添加表头
        ListNode res = new ListNode(-1); 
        ListNode head = res;
        //进位符号
        int carry = 0; 
        //只要某个链表还有或者进位还有
        while(head1 != null || head2 != null || carry != 0){ 
            //链表不为空则取其值
            int val1 = head1 == null ? 0 : head1.val; 
            int val2 = head2 == null ? 0 : head2.val;
            //相加
            int temp = val1 + val2 + carry; 
            //获取进位
            carry = temp / 10; 
            temp %= 10; 
            //添加元素
            head.next = new ListNode(temp); 
            head = head.next;
            //移动下一个
            if(head1 != null) 
                head1 = head1.next;
            if(head2 != null)
                head2 = head2.next;
        }
        //结果反转回来
        return ReverseList(res.next); 
    }
}




/////自己的屎山代码
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
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */
    static List<ListNode> ans = new ArrayList<>();
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        List<ListNode> list1 = new ArrayList<>();
        List<ListNode> list2 = new ArrayList<>();
        
        while(head1 != null) {
            list1.add(head1);
            head1 = head1.next;
        }
        while(head2 != null) {
            list2.add(head2);
            head2 = head2.next;
        }
        int index1 = list1.size()-1;
        int index2 = list2.size()-1;
        int jin = 0;
        while(index1 >= 0 && index2 >= 0) {
            int value = list1.get(index1).val + list2.get(index2).val;
            if(jin == 1) value++;
            if(value >= 10) {
                value = value - 10;
                jin = 1;
            }else{
                jin = 0;
            }
            ans.add(new ListNode(value));
            index1--;
            index2--;
        }
        addWay(list1,index1,jin);
        addWay(list2,index2,jin);
        int res = ans.size()-1;
        while(res>=1){
            ans.get(res).next = ans.get(res-1);
            res--;
        }
        return ans.get(ans.size()-1);
    }
    public static void addWay(List<ListNode> list,int index,int jin){
        if(index < 0){
            return;
        }
        while(index >= 0) {
            int value = list.get(index).val;
            if(jin == 1){
                value++;
            }
            if(value >= 10) {
                value = value - 10;
                jin = 1;
            }else{
                jin = 0;
            }
            ans.add(new ListNode(value));
            index--;
        }
        if(jin==1){
            ans.add(new ListNode(1));
        }
    }
}
