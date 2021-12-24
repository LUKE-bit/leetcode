class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2) {
                if(o1[1] != o2[1]) {
                    return Integer.compare(o1[1],o2[1]);
                }else {
                    return Integer.compare(o1[0],o2[0]);
                }
            }
        });
        int count = 1;
        int edge = intervals[0][1];
        for(int i = 1;i < intervals.length;i++) {
            if(edge <= intervals[i][0]) {
                count++;
                edge = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
