class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[nums.length+2];
        for(int i=0;i<n;i++){
            arr[i+1] = nums[i];
        }
        arr[0] = 1;
arr[n + 1] = 1; 
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
       return maxCoins(1,n,arr,dp);

    }

    private int maxCoins(int l, int r, int[]arr,int[][]dp){
        if(l>r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
 

        dp[l][r] = 0;
        for(int ind=l;ind<=r;ind++){
           int coins=arr[l-1]*arr[ind]*arr[r+1];
            coins+=   maxCoins(l,ind-1,arr,dp) + maxCoins(ind+1,r,arr,dp);
            dp[l][r] =Math.max(dp[l][r],coins);
        }

        return dp[l][r];
    }
}
