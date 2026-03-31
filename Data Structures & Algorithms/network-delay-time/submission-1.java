class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> adjList = new HashMap<>();
        for(var time:times){
            adjList.computeIfAbsent(time[0],x->new ArrayList<>()).add(new int[]{time[1],time[2]});
        }

        int[] dist = new int[n+1];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        dfs(adjList,k,0,dist);

       int res = Arrays.stream(dist).max().getAsInt();
       return res==Integer.MAX_VALUE ?-1:res;
    }

    public void dfs(Map<Integer,List<int[]>> adjList, int node, int time,int[] dist){
        if(time>=dist[node]) return;

        dist[node] = time;
        if(!adjList.containsKey(node)) return;
        for(var edge: adjList.get(node)){
            dfs(adjList,edge[0],time+edge[1],dist);
        }
    }
}
