class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> adjList = new HashMap<>();

        for(var time:times){
            adjList.computeIfAbsent(time[0],x->new ArrayList<>()).add(new int[]{time[1],time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.add(new int[]{0,k});
        Set<Integer> visited = new HashSet<>();
        int t = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int w = curr[0];
            int v = curr[1];
            if(visited.contains(v)) continue;
            visited.add(v);
            t=w;
            if(!adjList.containsKey(v))continue;
            for(var nei:adjList.get(v)){
               pq.add(new int[]{w+nei[1],nei[0]}); 
            }
        }
        return visited.size()==n?t:-1;
    }
}
