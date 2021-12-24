class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        char[] chars = s.toCharArray();
        int[] maxId = new int[26];
        for(int i = 0;i < chars.length;i++) {
            maxId[chars[i] - 'a'] = i;
        }
        int idMax = 0;
        int last = -1;
        for(int i = 0;i < chars.length;i++) {
            idMax = Math.max(idMax,maxId[chars[i] - 'a']);
            if(idMax == i) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }
}
