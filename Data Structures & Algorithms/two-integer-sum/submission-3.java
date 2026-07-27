class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int pair = target-nums[i];
            if(map.containsKey(pair)){
                int ind = map.get(pair);
                return new int[]{ind,i};
            }
            map.put(nums[i],i);
        }
    return new int[]{-1,-1};
    }
}
