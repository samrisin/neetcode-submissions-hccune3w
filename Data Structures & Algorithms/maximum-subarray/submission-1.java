class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int currSum=0;
        for(int num:nums){
            currSum+=num;
            res=Math.max(res,currSum);
             if(currSum<0){
                currSum=0;
            }
        }

        return res;
    }
}
