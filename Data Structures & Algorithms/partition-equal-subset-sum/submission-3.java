class Solution {
    
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

        }

        if(sum%2!=0) return false;
        int target = sum/2;
        Boolean [][] dp = new Boolean[nums.length+1][target+1];
        return dfs(target, nums,0,dp);
    }


    public boolean dfs(int target, int[]nums,int i,Boolean[][]dp){
        
        if(target==0) return true;

        if(i==nums.length) return false;

        if(dp[i][target]!=null) return dp[i][target];

        boolean take = nums[i]>target?false:dfs(target-nums[i],nums,i+1,dp);
        boolean skip = dfs(target,nums,i+1,dp);
        dp[i][target] = take||skip;
        return dp[i][target];
    }
}
