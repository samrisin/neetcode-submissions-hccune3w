class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            if(nums[l]+nums[r]>target){
                r--;
            }else if(nums[r]+nums[l]<target){
                l++;
            }else{
                 return new int[]{l+1,r+1};
            }
           
        }
        return new int[]{-1,-1};
    }
}
