class Solution {
    int n;
    public int maxProfit(int[] prices) {
        n = prices.length;
        int dp[][] = new int[n][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
          return getProfit(prices,0,1,dp);
    }

    public int getProfit(int[]prices,int i,int buy,int[][] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            return dp[i][buy] = Math.max(-prices[i]+getProfit(prices,i+1,0,dp),getProfit(prices,i+1,1,dp));
        }else{
             return dp[i][buy] = Math.max(prices[i]+getProfit(prices,i+2,1,dp),getProfit(prices,i+1,0,dp));
        }
    }
}
