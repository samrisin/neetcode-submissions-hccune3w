class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        for(int c=0;c<triangle.get(n-1).size();c++){
            dp[n-1][c] = triangle.get(n-1).get(c);
        }

        for(int i=n-2;i>=0;i--){
            for(int j =0;j<triangle.get(i).size();j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        } 
    return dp[0][0];
    }
}