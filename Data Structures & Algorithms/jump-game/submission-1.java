class Solution {
    public boolean canJump(int[] nums) {
        int maxJump=0;
        int n = nums.length-1;
        for(int i =0;i<nums.length;i++){
            if(i<=maxJump){
            maxJump = Math.max(maxJump,i+nums[i]);
            }
            if(maxJump>=n) return true;

        }
        return false;
    }
}
