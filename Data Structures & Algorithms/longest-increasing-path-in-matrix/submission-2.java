class Solution {
    int n;
    int m;
    int[][] dp;
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    int maxVal = 1;
    public int longestIncreasingPath(int[][] matrix) {
         n =matrix.length;
         m = matrix[0].length;
        dp = new int[n][m];
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]==0){
                    dp[i][j]=dfs(i,j,matrix,dp);
                    maxVal = Math.max(dp[i][j],maxVal);
                    
                }
            }
         }
        return maxVal;
    }


    public int dfs(int i, int j, int[][]matrix, int[][]dp){
        if(dp[i][j]!=0) return dp[i][j];
        dp[i][j] = 1;
        for(var dir:dirs){
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(nr<0 || nc<0 || nr>=n|| nc>=m || matrix[nr][nc]<=matrix[i][j]) continue;

           dp[i][j] = Math.max(dp[i][j], 1 + dfs(nr, nc, matrix, dp));

        }

        return dp[i][j];
    }
}
