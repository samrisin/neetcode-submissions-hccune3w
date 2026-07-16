class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int edgesUsed = 0;
        boolean[]inMST = new boolean[n];

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        int mstCost=0;
        while(edgesUsed<n){
            int currNode= -1;  
            int currMinEdge = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(!inMST[i] && currMinEdge> dist[i]){
                    currMinEdge = dist[i];
                    currNode = i;
                }
            }
            mstCost += currMinEdge; 
            edgesUsed++;
            inMST[currNode] = true;

            for(int j=0;j<n;j++){
int weight = Math.abs(points[currNode][0] - points[j][0]) 
           + Math.abs(points[currNode][1] - points[j][1]);

                if(weight<dist[j] && !inMST[j]){
                     dist[j] = weight;
                }

            }

        }

        return mstCost;
    }
}