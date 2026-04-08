class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = newNums[n+1] = 1;
        for(int i=0;i<n;i++){
            newNums[i+1] = nums[i];
        }

        int[][]dp = new int[n+2][n+2];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        } 
        return getMaxCoins(newNums,1,newNums.length-2,dp);
    }

    public int getMaxCoins(int[] nums,int l, int r, int[][]dp){
        if(l>r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        dp[l][r] = 0;
        for(int i=l;i<=r;i++){
            int coins = nums[i]*nums[l-1]*nums[r+1];
            coins+=getMaxCoins(nums,l,i-1,dp) + getMaxCoins(nums,i+1,r,dp);
            dp[l][r] = Math.max(dp[l][r],coins);
        }
        return dp[l][r];
    }
}
