import java.util.*;
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) return null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy,cur = pHead;
        while(cur!=null) {
            RandomListNode clone = new RandomListNode(cur.label);
            pre.next = clone;
            map.put(cur,clone);
            pre = pre.next;
            cur = cur.next;
        }
        for(Map.Entry<RandomListNode,RandomListNode> entry:map.entrySet()){
            entry.getValue().random = entry.getKey().random == null?null:map.get(entry.getKey().random);
        }
        return map.get(pHead);
    }
}
