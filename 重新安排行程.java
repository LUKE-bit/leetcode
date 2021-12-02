//本题使用优先队列，解决欧拉通路的问题需要用到Hierholzer 算法
//流程如下：
//1.从起点出发，进行深度优先搜索。

//2.每次沿着某条边从某个顶点移动到另外一个顶点的时候，都需要删除这条边。

//3.如果没有可移动的路径，则将所在节点加入到栈中，并返回。
class Solution {
    Map<String,PriorityQueue<String>> map = new HashMap<>();
    List<String> ans = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket:tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if(!map.containsKey(src)) {
                map.put(src,new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }
    public void dfs(String path) {
        while(map.containsKey(path) && map.get(path).size() > 0) {
            String temp = map.get(path).poll();
            dfs(temp);
        }
        ans.add(path);
    }
}

//也可以使用回溯法
class Solution {
    private Deque<String> res;
    private Map<String, Map<String, Integer>> map;

    private boolean backTracking(int ticketNum){
        if(res.size() == ticketNum + 1){
            return true;
        }
        String last = res.getLast();
        if(map.containsKey(last)){//防止出现null
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int count = target.getValue();
                if(count > 0){
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if(backTracking(ticketNum)) return true;
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, Map<String, Integer>>();
        res = new LinkedList<>();
        for(List<String> t : tickets){
            Map<String, Integer> temp;
            if(map.containsKey(t.get(0))){
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else{
                temp = new TreeMap<>();//升序Map
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);

        }
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }
}
