class Solution {
    int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    int n;
    int m;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
         n = heights.length;
         m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][]atlantic = new boolean[n][m];
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<m;i++){
            dfs(0,i,pacific,heights);
            dfs(n-1,i,atlantic,heights);
        }

        for(int i=0;i<n;i++){
            dfs(i,0,pacific,heights);
            dfs(i,m-1,atlantic,heights);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }

        return result;
    }

    private void dfs(int r,int c,boolean[][] ocean, int[][]grid){
        ocean[r][c]=true;

        for(int[] d:directions){
            int nr = d[0] + r;
            int nc = d[1] + c;

            if(nc<m && nr<n && nr>=0 && nc>=0 && grid[nr][nc]>=grid[r][c] && !ocean[nr][nc]){
                dfs(nr,nc,ocean,grid);
            }
        }
    }



}
