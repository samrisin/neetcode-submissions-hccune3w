class Solution {
    int n;
    int m;
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        n = grid.length;
        m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                   maxArea = Math.max(maxArea,dfs(i,j,grid));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int i, int j, int[][]grid){
        if(i>=n || j>=m || i<0 || j<0|| grid[i][j]==0 ){
            return 0;
        }
        grid[i][j] = 0;
        int count =1;
        for(int[] dir:dirs){
            int nr = i+dir[0];
            int nj = j+dir[1];
            count+=dfs(nr,nj,grid); 
        }
        return count;
    }
}