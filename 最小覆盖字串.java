class Solution {
    HashMap<Character,Integer> cnt = new HashMap<Character,Integer>();
    HashMap<Character,Integer> ori = new HashMap<Character,Integer>();
    public String minWindow(String s, String t) {
        int tlen = t.length();
        for(int i = 0;i < tlen;i++) {
            char c = t.charAt(i);
            ori.put(c,ori.getOrDefault(c,0) + 1);
            
        }
        int l = 0,r = -1,ansL = -1,ansR = -1;
        int len = Integer.MAX_VALUE;
        int slen = s.length();
        while(r < slen) {
            r++;
            if(r < slen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
            }
            while(check()&&l <= r) {
                if(r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l+len;
                }
                if(ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l),cnt.getOrDefault(s.charAt(l),0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL,ansR);
    }
    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character)entry.getKey();
            Integer val = (Integer)entry.getValue();
            if(cnt.getOrDefault(key,0) < val) {
                return false;
            } 
        }
        return true;
    }
}
