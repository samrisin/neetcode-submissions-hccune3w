class Solution {
    int n;
    int m;
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        int islands = 0;
        n = grid.length;
        m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    dfs(i,j,grid);
                }
            }
        }
        return islands;
    }

    private void dfs(int i, int j, char[][]grid){
        if(i>=n || j>=m || i<0 || j<0|| grid[i][j]=='0' ){
            return;
        }
        grid[i][j] = '0';
        for(int[] dir:dirs){
            int nr = i+dir[0];
            int nj = j+dir[1];
            dfs(nr,nj,grid); 
        }
    }
}
