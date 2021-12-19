class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>() {
            public int compare(int[] people1,int[] people2) {
                if(people1[0] != people2[0]) {
                    return people2[0] - people1[0];
                }else {
                    return people1[1] - people2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        for(int[] person:people) {
            ans.add(person[1],person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
