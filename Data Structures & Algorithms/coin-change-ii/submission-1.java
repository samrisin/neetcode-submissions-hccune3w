class Solution {
    public int change(int amount, int[] coins) {
    int n = coins.length;

     int[][]dp= new int[n+1][amount+1];  

     for(int i=0;i<=n;i++){
        dp[i][amount]=1;
     } 

     for(int i=n-1;i>=0;i--){
        for(int sum=amount;sum>=0;sum--){
            int take = 0;

            if(sum+coins[i]<=amount){
                take = dp[i][sum+coins[i]];
            }

           int not_take = dp[i+1][sum];

            dp[i][sum] = take+not_take;
        }
     }

     return dp[0][0];
    }
}
