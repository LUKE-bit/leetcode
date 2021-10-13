class ListNode{
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val; 
    }
}
class MyLinkedList {
    int size = 0;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(-1);
    }
    
    public int get(int index) {
        if(index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for(int i = 0;i <= index;i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) {
            return;
        }
        if(index < 0) {
            index = 0;
        }
        size++;
        ListNode cur = head;
        ListNode newVal = new ListNode(val);
        for(int i = 0;i < index;i++) {
            cur = cur.next;
        }
        newVal.next = cur.next;
        cur.next = newVal;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
            return;
        }
        ListNode cur = head;
        for(int i = 0;i < index;i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
