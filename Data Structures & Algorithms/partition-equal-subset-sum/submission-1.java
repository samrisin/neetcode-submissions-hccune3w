class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }

        if(sum%2==1) return false;

        return findTarget(nums,0,0,sum/2);
    }

    public boolean findTarget(int[] nums, int i, int sum,int target){
       
        if(sum>target || i==nums.length) return false;
        if(sum==target) return true;
        return findTarget(nums,i+1,sum+nums[i],target) || 
        findTarget(nums,i+1,sum,target);
    }
}
