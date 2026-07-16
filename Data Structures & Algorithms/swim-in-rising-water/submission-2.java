class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        int[][] dirs= {{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] visited = new boolean[n][n];
    
        pq.add(new int[]{grid[0][0],0,0});

 
        int maxTime = Integer.MIN_VALUE;
        visited[0][0] = true;

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int w = curr[0];
            int r = curr[1];
            int c = curr[2];
            maxTime = Math.max(w,maxTime);
            if(r==n-1 && c==n-1) return maxTime;

            for(var dir:dirs){
                int nr = r+dir[0];
                int nc = c + dir[1];

                if(nr>=0 && nr<n && nc<n && nc>=0 && !visited[nr][nc]){
                    pq.add(new int[]{grid[nr][nc],nr,nc});
                    visited[nr][nc] = true;
                }
            }

        }
    return maxTime;
    }
}
