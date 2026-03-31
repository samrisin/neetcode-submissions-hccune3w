class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int node = 0;
        int res = 0;
        int edges =0;
        int[]dist = new int[n];
        Arrays.fill(dist,100000000);
        boolean[] visited = new boolean[n]; 
        while(edges<n-1){
            int nextNode = -1;
            visited[node] = true;
             for(int i=0;i<n;i++){
                if(visited[i])continue;
                int currDist = Math.abs(points[i][0]-points[node][0])+
                Math.abs(points[i][1]-points[node][1]);
                dist[i] = Math.min(dist[i],currDist);
                if(nextNode==-1 || dist[i]<dist[nextNode]){
                    nextNode = i;
                }

             }
             res+=dist[nextNode];
             node = nextNode;
             edges++;
        }
        return res;
    }
}
