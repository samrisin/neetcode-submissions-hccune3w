class Solution {
    public int orangesRotting(int[][] grid) {
        int mins = 0;

        Queue<int[]> q = new ArrayDeque<>();
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        int n = grid.length;
        int m = grid[0].length;
        int freshfruits = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    freshfruits++;
                }
            }
        }

        while(!q.isEmpty() && freshfruits>0){
            int size = q.size();
            boolean rot = false;
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                for(var dir:dirs){
                    int nr = curr[0]+dir[0];
                    int nj = curr[1] + dir[1];

                    if(nr>=0 && nj>=0 && nr<n && nj<m && grid[nr][nj]==1){
                        q.add(new int[]{nr,nj});
                        grid[nr][nj] = 2;
                        freshfruits--; 
                        rot = true;
                    }
                }

            }
            mins+= rot?1:0;
        }
        System.out.println(freshfruits);
    return freshfruits==0?mins:-1;
    }
}
